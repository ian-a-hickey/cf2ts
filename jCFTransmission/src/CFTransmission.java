import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class CFTransmission {
	static CFTransmissionListener listener = null;
	static String cfcFileList = null;
	static String[] cfcFiles = null;
	static String action  = "";
	static String cfcFile = System.getProperty("user.dir") + "/test/test-source.txt";
	static String returnType = "source";
	static String tsFile = "";
	static Integer numberOfFiles = 0;
	static ArrayList<String> propertyList;
	static String sourceText = "";
	
	public CFTransmission() {
		//Here so we can instantiate the class from coldfusion.
	} 
	
	/**
	 * Returns a Coldfusion array of all properties found in a source file.
	 * @param fileName
	 * @return
	 */
	public static ArrayList<String> getPropertiesFromFile(String fileName){
		// Get our lexer		
	    CFTransmissionLexer lexer = null;
		try {
			lexer = new CFTransmissionLexer(new ANTLRFileStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // Get a list of matched tokens
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	 
	    // Pass the tokens to the parser
	    CFTransmissionParser parser = new CFTransmissionParser(tokens);
	    
	    // Specify our entry point
	    CFTransmissionParser.ComponentContext componentData = parser.component();
	    
	    // Walk it and attach our listener
	    ParseTreeWalker walker = new ParseTreeWalker();
	    
	    //Switch the listener based on the passed in arguments.
	    
	    listener = new MergeEntities(parser, tokens, fileName, "get");
	    
	    walker.walk(listener, componentData);
		//System.out.println(propertyList.toString());
		return propertyList;
		
	}
	/**
	 * Add the given properties to the beginning of the component in the given source-file.
	 * @param properties
	 * @param fileName
	 * @return Returns the source code containing the new properties added.
	 */
	public static String  addPropertiesToFile(String properties, String fileName){
		propertyList = new ArrayList<String>();
		propertyList.add(properties);
		// Get our lexer		
	    CFTransmissionLexer lexer = null;
		try {
			lexer = new CFTransmissionLexer(new ANTLRFileStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // Get a list of matched tokens
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	 
	    // Pass the tokens to the parser
	    CFTransmissionParser parser = new CFTransmissionParser(tokens);
	    
	    // Specify our entry point
	    CFTransmissionParser.ComponentContext componentData = parser.component();
	    
	    // Walk it and attach our listener
	    ParseTreeWalker walker = new ParseTreeWalker();
	    
	    //Switch the listener based on the passed in arguments.
	    //Test add
	    listener = new MergeEntities(parser, tokens, fileName, "add");
	    
	    walker.walk(listener, componentData);
	    //System.out.println(sourceText);
	    propertyList.add(sourceText);
		return sourceText;
	}
	
	/**
	 * Add the given properties to the beginning of the component in the given source-file.
	 * @param tsFile
	 * @param cfcfile
	 * @return returns the typescript version of the cfc file.
	 */
	public static String transpile(String cfcfile, String outFile, String ERROR_MODE){
		
		tsFile = outFile;
		// Get our lexer
	    CFTransmissionLexer lexer = null;
		try {
			lexer = new CFTransmissionLexer(new ANTLRFileStream(cfcfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    // Get a list of matched tokens
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	 
	    // Pass the tokens to the parser
	    CFTransmissionParser parser = new CFTransmissionParser(tokens);
	    
	    //Check the error mode and setup the error listener accordingly.
	    if (ERROR_MODE.equals("TOCONSOLE")){
	    	//nothing to be done as this is the default behavior.
	    }else if (ERROR_MODE.equals("TOFILE")){
	    	//setup a error file. need to implement a class for this.
	    }else if (ERROR_MODE.equals("NONE")){
	    	//Tell the parser to shut it.
	    	//System.out.println("Setting Mode To: " + ERROR_MODE);
	    	//Remove the old error listeners and add the new one.
	    	parser.removeErrorListeners();
	    	parser.addErrorListener(ThrowNoErrorsListener.INSTANCE);
	    	lexer.removeErrorListeners();
	    	lexer.addErrorListener(ThrowNoErrorsListener.INSTANCE);
	    }
	    
	    //Add the custom error listener
	    parser.removeErrorListeners(); //Removes the default error listener
	    
	    // Specify our entry point
	    CFTransmissionParser.ComponentContext componentData = parser.component();
	    
	    // Walk it and attach our listener
	    ParseTreeWalker walker = new ParseTreeWalker();
	    
	    //Switch the listener based on the passed in arguments.
	    listener = new TranspileToTypescript(parser, tokens, cfcfile, outFile, "transpile", false);//last option for generating get and set decorators
	    
	    walker.walk(listener, componentData);
	    
	    //Save source to file
		return sourceText;
	}
	
	/**
	 * Removes a property from a Coldfusion component
	 * @param properties
	 * @param fileName
	 * @return
	 */
	public static String removePropertiesFromFile(String properties, String fileName){
		propertyList = new ArrayList<String>();
		propertyList.add(properties);
		
		// Get our lexer		
	    CFTransmissionLexer lexer = null;
		try {
			lexer = new CFTransmissionLexer(new ANTLRFileStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // Get a list of matched tokens
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	 
	    // Pass the tokens to the parser
	    CFTransmissionParser parser = new CFTransmissionParser(tokens);
	    
	    
	    // Specify our entry point
	    CFTransmissionParser.ComponentContext componentData = parser.component();
	    
	    // Walk it and attach our listener
	    ParseTreeWalker walker = new ParseTreeWalker();
	    
	    //Switch the listener based on the passed in arguments.
	    //Test add
	    listener = new MergeEntities(parser, tokens, fileName, "remove");
	    
	    walker.walk(listener, componentData);
	    //System.out.println(sourceText);
	    propertyList.add(sourceText);
		return sourceText;
		
	}
	
	/**
	 * Injects entity naming information into the source text.
	 * @param properties
	 * @param fileName
	 * @return
	 */
	public static String injectEntityNameInformation(String properties, String fileName, String data){
		propertyList = new ArrayList<String>();
		propertyList.add(properties);
		
		// Get our lexer		
	    CFTransmissionLexer lexer = null;
		try {
			lexer = new CFTransmissionLexer(new ANTLRFileStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // Get a list of matched tokens
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	 
	    // Pass the tokens to the parser
	    CFTransmissionParser parser = new CFTransmissionParser(tokens);
	    
	    // Specify our entry point
	    CFTransmissionParser.ComponentContext componentData = parser.component();
	    
	    // Walk it and attach our listener
	    ParseTreeWalker walker = new ParseTreeWalker();
	    
	    //Switch the listener based on the passed in arguments.
	    //Test add
	    listener = new UpdateEntityName(parser, tokens, fileName, data);
	    
	    walker.walk(listener, componentData);
	    propertyList.add(sourceText);
		return sourceText;	
	}
}
