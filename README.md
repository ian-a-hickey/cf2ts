# cf2ts
A coldfusion to typescript transpiler

Right-click your project name in Eclipse and select 'run/debug' settings. Add a new config for Java Application and under the 'Arguments' tab 
add an action, source, and output. For example, my config looks like:

    -action transpile 
         -s /Users/ianhickey/Documents/workspace/antlr/jCFTransmission/test/test.cfc 
         -o /Users/ianhickey/Documents/workspace/antlr/jCFTransmission/test/test.ts
         
That should allow you to transpile a cfc to a ts file.


