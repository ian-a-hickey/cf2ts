# cf2ts
A coldfusion to typescript transpiler

Right-click your project name in Eclipse and select 'run/debug' settings. Add a new config for Java Application and under the 'Arguments' tab 
add an action, source, and output. For example, my config looks like:

    -action transpile 
         -s /Users/ianhickey/Documents/workspace/antlr/jCFTransmission/test/test.cfc 
         -o /Users/ianhickey/Documents/workspace/antlr/jCFTransmission/test/test.ts
         
That should allow you to transpile a cfc to a ts file.

# Transpile whole directory.

To transpile an entire directory in one go, add the command line option -all to your run configuration.

Right-click your project. Select Run-As/Run Configurations and select the Arguments tab. Add the -all flag to your arguments list. When using -all to transpile a directory, the -o (output) and -s (source) become the directories to read from and write to. The ouput .ts files will overwrite any files that already exist with the same names in that output directory.

    -action transpile -all
         -s /Users/ianhickey/Documents/workspace/antlr/jCFTransmission/test/ 
         -o /Users/ianhickey/Documents/workspace/antlr/jCFTransmission/testoutput/

#Turn off transpiler warnings 

To turn off the default warning that appear when transpiling a file, use the -e NONE option on the command line.

    -action transpile -all -s /Users/ianhickey/git/cf2ts/jCFTransmission/test -o /Users/ianhickey/git/cf2ts/jCFTransmission/test -e NONE
    
Additionally, an option for logging to console (default) or logging to a file was added.

    -action transpile -all -s /Users/ianhickey/git/cf2ts/jCFTransmission/test -o /Users/ianhickey/git/cf2ts/jCFTransmission/test -e {NONE, TOCONSOLE, TOFILE}
    
    
    




