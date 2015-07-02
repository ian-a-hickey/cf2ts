/**
 * @author ianhickey
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

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
public class MergeEntities extends CFTransmissionBaseListener {
	String fileName = "";
	String componentName = "";
	String propertyName = "";
	String methodName = "";
	Parser myParser;
	TokenStream tokens = null;
	TokenStreamRewriter rewriter;
	int position = 0;
	String actionType = "get";
	ArrayList<String> propertyList; 
	StringBuilder propertyAttributes;
	boolean isInserted;
	boolean isRemoved = false;
	
	/**
	 * Public constructor
	 * @param myParser
	 * @param tokens
	 * @param fileName
	 * @param actionType
	 */
	public MergeEntities(Parser myParser, TokenStream tokens, String fileName, String actionType) {
		super();
		this.myParser = myParser;
		this.tokens = tokens;
		this.fileName = fileName;
		this.actionType = actionType;
		rewriter = new TokenStreamRewriter(tokens);
		propertyList = new ArrayList<String>();
		propertyAttributes = new StringBuilder();
	}
	
	
	/**
	 * Transforms a property declaration into its annotated counterpart
	 */
	@Override
	public void enterPropertyDeclaration(CFTransmissionParser.PropertyDeclarationContext propertyCtx){
		
		//We do this when finding properties
		propertyAttributes.append("property ");
		if (this.actionType.equals("get")){
			List<CFTransmissionParser.KeyValueContext> keyValueList = propertyCtx.keyValue();
			
			for (CFTransmissionParser.KeyValueContext keyVal : keyValueList){
				//writeDump(keyVal.getText() + " ");
				propertyAttributes.append(keyVal.getText() + " ");
			}
		}
		
		else if (this.actionType.equals("add") && !isInserted){
			rewriter.insertBefore(propertyCtx.getStart(), CFTransmission.propertyList.get(0) + "\n\t");
			this.isInserted = true;
		}
		
		else if (this.actionType.equals("remove") && !isRemoved){
			if (CFTransmission.propertyList.get(0).equals(propertyCtx.getText()))
			rewriter.delete(propertyCtx.getStart(), propertyCtx.getStop());
			this.isRemoved = true;
		}
		
	}
	
	/**
	 * Transforms a property declaration into its annotated counterpart
	 */
	@Override
	public void exitPropertyDeclaration(CFTransmissionParser.PropertyDeclarationContext propertyCtx){
		if (this.actionType.equals("get")){
			propertyAttributes.append(";\n");
			//writeDump(";\n");
			propertyList.add(propertyAttributes.toString());
			propertyAttributes = new StringBuilder();
		}
		else if (this.actionType.equals("remove")){
			CFTransmission.sourceText = rewriter.getText();
		}
	}
	
	
	/**
	 * Fires on done processing file
	 */
	@Override
	public void exitComponent(CFTransmissionParser.ComponentContext componentCtx){
		if (this.actionType.equals("get")){
			CFTransmission.propertyList = propertyList;
		}else if (this.actionType.equals("add")){
			CFTransmission.sourceText = rewriter.getText();
		}
	}
	
	//<--Helper print method
	public static void writeDump(String text){
		System.out.print(text);
	}

}

