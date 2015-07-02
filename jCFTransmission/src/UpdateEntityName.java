/**
 * @author ianhickey
 *
 */
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * @author ianhickey
 * Accepts a source and a destination, and updates a Coldfusion Component with the options specified.
 * Merges two components methods and properties by parsing source_1, and source_2 and outputting source_3.
 * 
 * The product of the two source files will contain all properties and methods from both in the output.
 * 
 * This process is additive, and when confronted with two properties with the same name, the property from
 * the second source file is left out of the product UNLESS overwrite = true in the options configuration.
 * 
 * Additionally, a custom prefix can be enforced by passing that prefix. In that case, all properties and method
 * from the second source must contain that prefix in the name.
 */
public class UpdateEntityName extends CFTransmissionBaseListener {
	String fileName = "";
	String componentName = "";
	String propertyName = "";
	String methodName = "";
	String entityName = "";
	Parser myParser;
	TokenStream tokens = null;
	TokenStreamRewriter rewriter;
	int position = 0;
	
	/**
	 * Update Entity Naming Convention
	 * @param myParser
	 * @param tokens
	 * @param fileName
	 */
	public UpdateEntityName(Parser myParser, TokenStream tokens, String fileName, String entityName) {
		super();
		this.myParser = myParser;
		this.tokens = tokens;
		this.fileName = fileName;
		this.entityName = entityName;
		rewriter = new TokenStreamRewriter(tokens);
	}
	
	/**
	 * Turns the component definition into doc comments.
	 */
	@Override
	public void enterComponent(CFTransmissionParser.ComponentContext componentCtx){
		List<CFTransmissionParser.KeyValueContext> keyValueList = componentCtx.keyValue();
		for (CFTransmissionParser.KeyValueContext keyVal : keyValueList){
			if (keyVal.getText().toLowerCase().contains("entityname=")){
				componentName = keyVal.getText().replace(" ", "").split("\"")[1];
				rewriter.replace(keyVal.start, keyVal.stop, "entityName='"+ entityName+componentName +"'");
				continue;
			}//<--end if
		}//<--end for
	}//<--end enter
	
	/**
	 * Transforms a component declaration into its annotated counterpart.
	 */
	@Override
	public void exitComponent(CFTransmissionParser.ComponentContext componentCtx){
		rewriter.replace(componentCtx.getStop(), "\n}//<--end component\n");
		writeDump(rewriter.getText());
	}
	
	//<--Helper print method
	public static void writeDump(String text){
		System.out.print(text);
	}

}

