package com.leet.code;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {

	private List<Integer> array;

	private int minElement;

	public MinStack() {
		array = new ArrayList<>();
		minElement = Integer.MAX_VALUE;
	}

	public void push(int x) {
		if (x < minElement) {
			minElement = x;
		}
		array.add(x);
	}

	public void pop() {
		array.remove(array.size() - 1);
		minElement = Integer.MAX_VALUE;
		if (!array.isEmpty()) {
			for (int i : array) {
				if (i < minElement) {
					minElement = i;
				}
			}
		}
	}

	public int top() {
		return array.get(array.size()-1);
	}

	public int getMin() {
		return minElement;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // return -3
		minStack.pop();
		System.out.println(minStack.top());    // return 0
		System.out.println(minStack.getMin()); // return -2
	}
}
