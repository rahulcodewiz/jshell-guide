package com.ts.util;

import java.util.regex.Pattern;

public class Utils {
    /**
     * Regex Replace example using pattern
     * @param input source string
     * @param regex regex to search pattern
     * @param replacement replacement string
     * @return
     */
    public static String regexReplace(String input, String regex, String replacement){
        validateArg(input,"input");
        validateArg(input,"regex");
        validateArg(input,"replacement");
        return Pattern.compile(regex).matcher(input).replaceAll(replacement);
    }

    private static void validateArg(String input,String type) {
        if(input == null || input.isEmpty()){
            System.err.println(String.format("%s is blank",type));
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        System.out.println("jshell example");
    }
}
