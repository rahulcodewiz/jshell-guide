# jshell-example
------------
###Make sure java home is pointing to JDK-9
```
java -version
rauls-MacBook-Pro:common-utils rahul$ java -version
java version "9"
Java(TM) SE Runtime Environment (build 9+181)
Java HotSpot(TM) 64-Bit Server VM (build 9+181, mixed mode)
```
-------------

####Compile source code:
```
javac -d mods --module-source-path src $(find src -name '*.java')
```
####Test 
```
java -p mods -m com.ts.util/com.ts.util.Utils
```
####Create package/jar
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
####Lets try it with jshell