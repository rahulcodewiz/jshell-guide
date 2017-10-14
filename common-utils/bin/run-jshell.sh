echo "$1" | jshell --class-path '/Users/rahul/Documents/study/jshell-example/common-utils/mods/com.ts.util@1.0.jar' --feedback concise |sed -n '2p' | sed -En 's/[^>]*>(.+)/\1/gp'
