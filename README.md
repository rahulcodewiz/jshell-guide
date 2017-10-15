# jshell-example

Step by steps guide to create java module and run on jshell (REPL) then try on unix shell script
------------------------------------------------------------------------------------------------
##Make sure java home is set to JDK-9
```
java -version
rauls-MacBook-Pro:common-utils rahul$ java -version
java version "9"
Java(TM) SE Runtime Environment (build 9+181)
Java HotSpot(TM) 64-Bit Server VM (build 9+181, mixed mode)
```
-------------

##Compile source code:
```
javac -d mods --module-source-path src $(find src -name '*.java')
```
##Test 
```
java -p mods -m com.ts.util/com.ts.util.Utils
```
##Create package/jar
```
jar --create --file=mods/com.ts.util@1.0.jar --module-version=1.0 -C mods/com.ts.util .
jar --create --file=mods/com.ts.util.jar --main-class com.ts.util.Utils -C mods/com.ts.util .
tree mods
mods
├── com.ts.util
│   ├── com
│   │   └── ts
│   │       └── util
│   │           └── Utils.class
│   └── module-info.class
├── com.ts.util.jar
└── com.ts.util@1.0.jar
```

-------------
##Lets try it with jshell

rauls-MacBook-Pro:common-utils rahul$ jshell --class-path 'mods/com.ts.util@1.0.jar'
|  Welcome to JShell -- Version 9
|  For an introduction type: /help intro

jshell> com.ts.util.Utils.regexReplace("jshell hello world","\\s","++")
$1 ==> "jshell++hello++world"

##Try using bash command

echo 'com.ts.util.Utils.regexReplace("jshell hello world","\\s","++")' | jshell --class-path 'mods/com.ts.util@1.0.jar' --feedback concise |sed -n '2p' | sed -En 's/[^>]*>(.+)/\1/gp'

##You can also create one more script that will take argument as java command and run on jshell
```
./common-utils/bin/run-jshell.sh 'com.ts.util.Utils.regexReplace("jshell hello world","\\s","++")'
```