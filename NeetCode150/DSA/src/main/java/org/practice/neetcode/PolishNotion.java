package org.practice.neetcode;

import java.util.ArrayDeque;

public class PolishNotion {

    public static void main(String[] args) {
        PolishNotion obj = new PolishNotion();
        System.out.println(obj.evalRPN(new String[]{"1","2","+","3","*","4","-"}));
    }

    public int evalRPN(String[] tokens) {

        /*
        Input: tokens = ["1","2","+","3","*","4","-"]

Output: 5

Explanation: ((1 + 2) * 3) - 4 = 5

1 2 +
(2+1)
3 * = 9 4 -
9 - 4 = 5
         */
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack.push(solve(stack.pop(), stack.pop(), "+"));
                    break;
                case "-":
                    stack.push(solve(stack.pop(), stack.pop(), "-"));
                    break;
                case "*":
                    stack.push(solve(stack.pop(), stack.pop(), "*"));
                    break;
                case "/":
                    stack.push(solve(stack.pop(), stack.pop(), "/"));
                    break;
                default:
                    stack.push(s);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    String solve(String b, String a, String operation) {
        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);
        return switch (operation) {
            case "+" -> String.valueOf(num1 + num2);
            case "-" -> String.valueOf(num1 - num2);
            case "*" -> String.valueOf(num1 * num2);
            case "/" -> String.valueOf(num1 / num2);
            default -> "";
        };
    }
}
