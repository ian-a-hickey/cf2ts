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
public class GenerateDocComments extends CFTransmissionBaseListener {
	String fileName = "";
	String componentName = "";
	String propertyName = "";
	String methodName = "";
	Parser myParser;
	TokenStream tokens = null;
	TokenStreamRewriter rewriter;
	int position = 0;
	
	public GenerateDocComments(Parser myParser, TokenStream tokens, String fileName) {
		super();
		this.myParser = myParser;
		this.tokens = tokens;
		this.fileName = fileName;
		rewriter = new TokenStreamRewriter(tokens);
	}
	
	/**
	 * Turns the component definition into doc comments.
	 */
	@Override
	public void enterComponent(CFTransmissionParser.ComponentContext componentCtx){
		//writeDump("\n/**\n");//Start the comment
		String openingCommentToken = "/**";
		rewriter.insertBefore(componentCtx.getStart(), openingCommentToken);
		rewriter.delete(componentCtx.getStart());
		List<CFTransmissionParser.KeyValueContext> keyValueList = componentCtx.keyValue();
		int i = 0; //index
		for (CFTransmissionParser.KeyValueContext keyVal : keyValueList){
			int listSize = keyValueList.size();
			
			if (keyVal.getText().toLowerCase().contains("displayname=")){
				componentName = keyVal.getText().replace(" ", "").split("\"")[1];
				rewriter.delete(keyVal.getStart(), keyVal.getStop());
				continue;
			}
			//writeDump("*@" + keyVal.getText().replace("=", " ") + "\n");
			rewriter.replace(keyVal.getStart(), keyVal.getStop(), "\n*@" + keyVal.getText().replace(" ", "").replace("=", " "));
			if (i + 2 == listSize){
				//writeDump("*/\ncomponent displayName = " + "\"" + componentName + "\" {\n");
				rewriter.replace(keyVal.getStart(), keyVal.getStop(),"\n*/\ncomponent displayName = " + "\"" + componentName + "\""); 
			}
			i++;
		}
		
	}
	
	/**
	 * Transforms a component declaration into its annotated counterpart
	 */
	@Override
	public void exitComponent(CFTransmissionParser.ComponentContext componentCtx){
		rewriter.replace(componentCtx.getStop(), "\n}//<--end component\n");
		//writeDump("\n}//<--end component\n");
		writeDump(rewriter.getText());
	}
	
	/**
	 * Transforms a property declaration into its annotated counterpart
	 */
	@Override
	public void enterPropertyDeclaration(CFTransmissionParser.PropertyDeclarationContext propertyCtx){
		//writeDump("\n/**\n");
		rewriter.replace(propertyCtx.getStart(), "\n\t/**\n");
		List<CFTransmissionParser.KeyValueContext> keyValueList = propertyCtx.keyValue();
		for (CFTransmissionParser.KeyValueContext keyVal : keyValueList){
			
			if (keyVal.getText().replace(" ", "").contains("name=")){
				propertyName = keyVal.getText().replace(" ", "").split("\"")[1];
				rewriter.delete(keyVal.getStart(), keyVal.getStop());
				continue;
			}
			//writeDump("*@" + keyVal.getText().replace("=", " ") + "\n");
			rewriter.replace(keyVal.getStart(),  keyVal.getStop(), "\t*@" + keyVal.getText().replace("=", " ") + "\n");
		}
		
	}
	
	/**
	 * Transforms a property declaration into its annotated counterpart
	 */
	@Override
	public void exitPropertyDeclaration(CFTransmissionParser.PropertyDeclarationContext propertyCtx){
		//writeDump("*/\n");
		rewriter.replace(propertyCtx.getStop(), "\t*/\n");
		rewriter.insertAfter(propertyCtx.getStop(), "\tproperty name = " + "\"" + propertyName + "\";\n");
		//writeDump("property name = " + "\"" + propertyName + "\";\n");
	}
	
	/**
	 * Transforms a function declaration into its annotated counterpart
	 */
	@Override
	public void enterFunctionDeclaration(CFTransmissionParser.FunctionDeclarationContext functionCtx){
		//writeDump("\n/**\n");
		CFTransmissionParser.FunctionNameContext functionName = functionCtx.functionName();
		methodName = functionName.getText();
		//writeDump("*@method " + methodName + "\n*@description ");
	}
	
	/**
	 * Transforms a function declaration into its annotated counterpart
	 */
	@Override
	public void exitFunctionDeclaration(CFTransmissionParser.FunctionDeclarationContext functionCtx){
		//Grab the token stream so we can retrieve the token we want.
		
		//End the comment
		//writeDump("\n*/\n");
		
		//Grab all the function identifiers such as scope and return type.
		List<TerminalNode> functionIdentifierList = functionCtx.Identifier();
		Object[] fil = functionIdentifierList.toArray();
		for (Object o : fil){
			//writeDump(o.toString() + " ");
		}
		//Add the method name;
		
		//writeDump( "function " + methodName );
		//writeDump("(");
		Iterator<CFTransmissionParser.ArgumentDefinitionContext> arguments = functionCtx.argumentsDefinition().argumentDefinition().listIterator();
		//While we have more arguments, print them.
		while (arguments.hasNext()){
			CFTransmissionParser.ArgumentDefinitionContext nextArgument = arguments.next();
			if (nextArgument.getChildCount() > 0){
				for (int i = 0; i <= nextArgument.getChildCount() - 1; i++){
					if (i == 0){
						//writeDump(" "); //add the opening space for style
					}
					if (nextArgument.getChild(i).getText().equals("=")){
						//writeDump(nextArgument.getChild(i).getText());
					}else{
						//writeDump( nextArgument.getChild(i).getText() + " ");
					}//<--end if
				}//<--end for
			}//<--end if
		}//<--end while
		//writeDump(")");
		//writeDump ("\n");
	}
	
	//<--Helper print method
	public static void writeDump(String text){
		System.out.print(text);
	}

}

