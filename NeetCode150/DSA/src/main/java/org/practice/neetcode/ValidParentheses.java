package org.practice.neetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class ValidParentheses {
    public static void main(String[] args) {
//        ValidParentheses obj = new ValidParentheses();
//        System.out.println(obj.isValid("([)]"));

        int a = 1;
        System.out.println(a++);
        System.out.println(a);
    }
    public boolean isValid(String s) {
	   ArrayDeque<Character> stack = new ArrayDeque<>();
       Set<Character> set = new HashSet<>();
       set.add('{');
       set.add('[');
       set.add('(');

       for(char c : s.toCharArray()) {
           if(set.contains(c)) {stack.push(c);}
           else {
               if(stack.isEmpty()) {return false;}
               char open = stack.pop();
               switch(c){
                   case '}':
                       if(open != '{')return false;
                       break;
                   case ']':
                           if(open != '[')return false;
                           break;
                   case ')':
                       if(open != '(')return false;
                       break;
               }
           }
       }
       return stack.isEmpty();
    }
}
