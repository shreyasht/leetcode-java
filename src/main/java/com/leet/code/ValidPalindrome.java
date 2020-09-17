package com.leet.code;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		String str = s.replaceAll("[^A-Za-z0-9]", "")
				.toLowerCase();

		boolean isPalindrome = true;
		int mid = str.length() - str.length() / 2;
		int i = 0;
		int j = str.length() - 1;

		String[] arr = str.split("");
		while ((i < str.length() && j > 0) && (i != mid || j != mid)) {
			if (!arr[i].equals(arr[j])) {
				isPalindrome = false;
				break;
			}
			i++;
			j--;
		}

		return isPalindrome;
	}


	public static void main(String[] args) {
		ValidPalindrome validPalindrome = new ValidPalindrome();
		//AmanaplanacanalPanama
		System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(validPalindrome.isPalindrome("race a car"));
	}


}
