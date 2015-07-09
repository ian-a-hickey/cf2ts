import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * CFTransmission is a source-code instrumentation project aimed at reading in
 * Coldfusion component source code and from that generating numerous types of
 * output such as annotated comments on the code, YAML, JSON, XML, API
 * documentation, etc. In short, CFTransmission is a code transpiler that
 * supports numerous types of output.
 * 
 * CFTransmission will return a number of types of data that are Coldfusion
 * compatible including Struct, Array, as well as simply writing the output to a
 * file.
 * 
 * CFTransmission can return the modified properties, individually or as an
 * entire modified source file.
 * 
 * @author ianhickey
 *
 */
@SuppressWarnings("deprecation")
public class Main {
	/**
	 * //This class allows us to access this project from the command line.
	 * 
	 * @param args
	 *            merge "file1,file2" source|struct|array
	 * @throws IOException
	 */
	@SuppressWarnings({ "unused", "static-access", "deprecation" })
	public static void main(String[] args) throws IOException {
		// |=================================================================================>>>
		// Get our lexer
		CFTransmissionListener listener = null;
		String v = "1.0.0";
		//Set the ERROR_MODE - {TOFILE, TOCONSOLE, NONE}
		String ERROR_MODE = "TOCONSOLE";
		String LOG_FILE = "cf2tslog.txt";
		String cfcFileList = null;
		String[] cfcFiles = null;
		String action = "";
		String cfcFile = System.getProperty("user.dir")
				+ "/test/test-source.txt";
		String tsFile = "";
		String returnType = "source";
		String properties = "";
		Integer numberOfFiles = 0;
		// |=================================================================================>>>
		// Handle CLI
		Option srcfile = OptionBuilder
				.withArgName("/path/to/file/filename.cfc")
				.hasArgs(1)
				.withValueSeparator()
				.withDescription(
						"source file to transpile to typescript including to path to that file as /path/to/file/filename.cfc")
				.create("s");

		Option outfile = OptionBuilder
				.withArgName("/path/to/output/directory/filename.ts")
				.hasArgs(1)
				.withDescription(
						"output file for the transpiled typescript including to path to that file as /path/to/file/filename.ts")
				.create("o");
		
		Option errorMode = OptionBuilder
				.withArgName("errorMode")
				.hasArgs(1)
				.withDescription(
						"sets the error logging mode. Valid modes are TOFILE, TOCONSOLE, NONE")
				.create("e");
		
		Option logfile = OptionBuilder
				.withArgName("logfilename")
				.hasArgs(1)
				.withDescription(
						"log file for log messages including to path to that file as /path/to/file/filename.txt")
				.create("l");

		Option props = OptionBuilder.withArgName("properties=value").hasArgs(2)
				.withDescription("a list of properties to add to a cfc")
				.create("p");

		Option nameChange = OptionBuilder.withArgName("name=value").hasArgs(2)
				.withDescription("change the name of an entity").create("c");

		Option actionOption = OptionBuilder
				.withArgName("value")
				.hasArgs(1)
				.withDescription(
						"the action to take: for example, transpile, merge, add ...")
				.create("action");

		Option help = new Option("help", "Display this help message");

		Option verbose = new Option("verbose",
				"show all console messages as transpile is happening");
		Option transpile = new Option("transpile",
				"transpile a sourcefile to an outputfile");
		Option get = new Option("get",
				"returns the properties and methods from a sourcefile");
		Option add = new Option("add",
				"adds properties and or methods to a source file");
		Option version = new Option("version", "displays the version");
		Option all = new Option(
				"all",
				"Indicates that all files in the source (-s path/to/files) should be transpiled into (-o path/to/output).");

		Options options = new Options();

		options.addOption(srcfile);
		options.addOption(outfile);
		options.addOption(logfile);
		options.addOption(verbose);
		options.addOption(transpile);
		options.addOption(get);
		options.addOption(add);
		options.addOption(version);
		options.addOption(props);
		options.addOption(nameChange);
		options.addOption(help);
		options.addOption(actionOption);
		options.addOption(errorMode);
		options.addOption(logfile);
		options.addOption(all);

		// |-->create the parser<--|//
		CommandLineParser parser = new DefaultParser();
		CommandLine line = null;

		try {
			// parse the command line arguments
			line = parser.parse(options, args);
		} catch (ParseException exp) {
			// oops, something went wrong
			System.err.println("Parsing failed.  Reason: " + exp.getMessage());
		}

		// Call constructors based on the command line
		if (line.hasOption("get") && line.hasOption("srcfile")) {
			action = "get";
			cfcFile = line.getOptionValue("srcfile");
			CFTransmission.getPropertiesFromFile(cfcFile);

		}

		else if (line.hasOption("help")) {
			System.out
					.println("Usage: -action {transpile, get, add, rename, ...} -all {all is options and will compile all file in source to output} -s srcfile=/path/to/file/filename.cfc -o outfile=/path/to/output/directory/filename.ts -v (verbose) -e logErrors={TOFILE, TOCONSOLE, NONE} -l logFile=/pathToFile/fileName.ext \n");

		}

		else if (line.hasOption("add") && line.hasOption("srcfile")) {
			action = "add";
			cfcFile = line.getOptionValue("srcfile");
			CFTransmission.addPropertiesToFile(
					"property name=\"customAddress\" persistent=\"false\";",
					cfcFile);
		}

		else if (line.hasOption("action") && line.hasOption("all")) {
			/**
			 * Transpile whole directory. Use the source as the source
			 * directory, and use the output as the output dir, and feed the
			 * output based on the return value of the directory list.
			 */
			// Are we using a log file?
			boolean isLogging = line.hasOption("l");
			if (isLogging) {
				String pathToLogFile = line.getOptionValue("logfile");
			}
			//System.out.println("Setting Mode To: " + line.hasOption("e"));
			if (line.hasOption("e") && line.hasOption("l")){
				ERROR_MODE = line.getOptionValue("e");
				LOG_FILE   = line.getOptionValue("l");	
				//System.out.println("Setting Mode To: " + ERROR_MODE);
			}else if (line.hasOption("e") && line.getOptionValue("e").equals("NONE")){
				ERROR_MODE = "NONE";
				//System.out.println("Setting Mode To: " + ERROR_MODE);
			}
			// Grab the list of files
			HashMap<String, String> listOfFiles = getDirectoryList(
					line.getOptionValue("s"), line.getOptionValue("o"));
			//System.out.println(listOfFiles.toString());
			// Iterate through the directory translating each file as we go.
			for (String file : listOfFiles.keySet()) {
				action = "transpile";
				cfcFile = file;
				tsFile = listOfFiles.get(cfcFile);
				System.out.println("Transpiling: " + cfcFile + " -> " + tsFile);
				CFTransmission.transpile(line.getOptionValue("s")
						+ java.io.File.separator + cfcFile,
						line.getOptionValue("o") + java.io.File.separator
								+ tsFile, ERROR_MODE);
			}

		} else if (line.hasOption("action")) {
			action = "transpile";
			cfcFile = line.getOptionValue("s");
			tsFile = line.getOptionValue("o");
			//System.out.println(tsFile);
			CFTransmission.transpile(cfcFile, tsFile, ERROR_MODE);
		}

	}

	/**
	 * Attempts to get a list of files from a directory.
	 * 
	 * @param pathToFiles
	 * @return A list of files with paths for processing
	 */
	public static HashMap<String, String> getDirectoryList(
			String pathToInputFiles, String pathToOutputFiles) {
		/**
		 * Holds the files
		 */
		HashMap<String, String> fileMap = new HashMap<String, String>();

		/**
		 * Attempt to get the file type and name and pushes to the list.
		 */
		try {
			File folder = new File(pathToInputFiles);
			ArrayList<String> names = new ArrayList<String>(
					Arrays.asList(folder.list()));
			//System.out.println(names.toString());
			for (String currentName : names) {
				File currentFile = new File(pathToInputFiles
						+ java.io.File.separator + currentName);
				if (currentFile.isFile()) {
					// Make sure it is a cfc that we are working with.
					if (currentFile.getName().toLowerCase().contains(".cfc")) {
						String fileNameWithPath = "";
						fileNameWithPath = currentFile.getName().split(".cfc")[0];
						//System.out.println(fileNameWithPath);
						fileMap.put(fileNameWithPath + ".cfc", fileNameWithPath
								+ ".ts");
					}

				} else if (currentFile.isDirectory()) {
					/** ignore sub-directories for now, but add option later. */
					// System.out.println("Directory " +
					// listOfFiles[i].getName());
				}
			}

		}// <--end try
		catch (Exception e) {
			e.printStackTrace();
		}

		return fileMap;
	}

}
