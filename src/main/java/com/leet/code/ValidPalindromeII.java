package com.leet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ValidPalindromeII {
	public static void main(String[] args) {
		System.out.println(validPalindrome("abc"));
	}

	public static boolean validPalindrome(String s) {
		int start = -1;
		int end = s.length();

		while (++start <= --end) {
			if (s.charAt(start) != s.charAt(end)) {
				return isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
			}
		}

		return true;
	}

	private static boolean isPalindrome(String s, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}

		return true;
	}
}
