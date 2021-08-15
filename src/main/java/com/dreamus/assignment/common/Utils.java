package com.dreamus.assignment.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static boolean isValidExpressionFormat(String value){
        String regex = "^[a-zA-Z[+][-]\\)\\(]*$";
        Matcher matcher = Pattern.compile(regex).matcher(value);
        return matcher.matches();
    }

    public static boolean isValidBrace(String value){
        Stack<String> stack = new Stack<>();
        Map<String,String> table = new HashMap<String, String>();
        table.put(")","(");

        value = value.replaceAll("[^//)//(]*","");
        if(value.isBlank()){
            return true;
        }

        for(String str : value.split("")){
            if(!table.containsKey(str)){
                stack.push(str);
            }
            else if(stack.isEmpty() || !table.get(str).equals(stack.pop())){
                return false;
            }
        }
        return stack.size() == 0;
    }
}
