package com.leet.code;

public class MinimumParenthesisToMakeValid {

	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("L(e)))et((co)d(e"));
	}

	private static StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
		StringBuilder sb = new StringBuilder();
		int balance = 0;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == open) {
				balance++;
			}
			if (c == close) {
				if (balance == 0) continue;
				balance--;
			}
			sb.append(c);
		}
		return sb;
	}

	public static String minRemoveToMakeValid(String s) {
		StringBuilder result = removeInvalidClosing(s, '(', ')');
		result = removeInvalidClosing(result.reverse(), ')', '(');
		return result.reverse().toString();
	}
}
