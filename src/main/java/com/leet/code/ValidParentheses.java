package com.leet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {

		if (s.startsWith("}") || s.startsWith("]") || s.startsWith(")"))
			return false;

		Stack<String> stack = new Stack<>();

		String[] inputArray = s.split("");

		for (String str : inputArray) {
			switch (str) {
				case "{":
				case "[":
				case "(":
					stack.push(str);
					break;
				case "}":
					if (!stack.isEmpty() && stack.peek().equals("{")) {
						stack.pop();
					} else {
						return false;
					}
					break;
				case "]":
					if (!stack.isEmpty() && stack.peek().equals("[")) {
						stack.pop();
					} else {
						return false;
					}
					break;
				case ")":
					if (!stack.isEmpty() && stack.peek().equals("(")) {
						stack.pop();
					} else {
						return false;
					}
					break;
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses validParentheses = new ValidParentheses();
		System.out.println("{[([{}])]} " + validParentheses.isValid("{[([{}])]}"));
		System.out.println("}{[]} " + validParentheses.isValid("}{[]}"));
		System.out.println("(] " + validParentheses.isValid("(]"));
		System.out.println("()[]{} " + validParentheses.isValid("()[]{}"));
		System.out.println("() " + validParentheses.isValid("()"));
		System.out.println("([)] " + validParentheses.isValid("([)]"));
		System.out.println("(]) " + validParentheses.isValid("(])"));
	}
}
