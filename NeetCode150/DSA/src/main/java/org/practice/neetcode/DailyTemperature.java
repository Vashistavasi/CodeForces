package org.practice.neetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class DailyTemperature {
    public static void main(String[] args) {
        DailyTemperature obj = new DailyTemperature();
        System.out.println(Arrays.toString(obj.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        stack push strictly decreasing once encountered an element is which is greater stop.
          10 9 8 7 6 8
          10 9 8 7(2 = (5-3)) 6(1 = (5-4)) 8

         */
        ArrayDeque<Integer[]> stack = new ArrayDeque<>();
        stack.push(new Integer[]{0, temperatures[0]});
        int[] ans = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++) {
            while (i<temperatures.length&& !stack.isEmpty() && stack.peek()[1] > temperatures[i]) {
                stack.push(new Integer[]{i, temperatures[i]});
                i++;
            }
            while(i<temperatures.length && !stack.isEmpty() && temperatures[i]> stack.peek()[1]){
                Integer [] curr = stack.pop();
                ans[curr[0]] = i-curr[0];
            }
            if(i<temperatures.length)
             stack.push(new Integer[]{i, temperatures[i]});
        }
        return ans;
    }
}
