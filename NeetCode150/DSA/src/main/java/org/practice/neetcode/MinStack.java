package org.practice.neetcode;

import java.util.Arrays;

class MinStack {
    int[] stack;
    int[] minStack;
    int top;
    int size;

    public MinStack() {
        this.stack = new int[32];
        this.minStack = new int[32];
        this.top = 0;
        this.size = 32;
    }

    public void push(int val) {
        if (top == size) {
            size *= 2;
            stack = Arrays.copyOf(stack, size);
            minStack = Arrays.copyOf(minStack, size);
        }

        stack[top] = val;

        if (top == 0) {
            minStack[top] = val;
        } else {
            minStack[top] = Math.min(val, minStack[top - 1]);
        }

        top++;
    }

    public void pop() {
        if (top == 0) return;
        top--;
    }

    public int top() {
        return stack[top - 1];
    }

    public int getMin() {
        return minStack[top - 1];
    }
}