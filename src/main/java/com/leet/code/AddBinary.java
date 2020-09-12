package com.leet.code;

/* https://leetcode.com/problems/add-binary/ */

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder stringBuilder = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;

		int carry = 0;

		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0) sum = sum + a.charAt(i) - '0';
			if (j >= 0) sum = sum + b.charAt(j) - '0';

			stringBuilder.append(sum % 2);
			carry = sum / 2;

			i--;
			j--;
		}

		if (carry != 0) stringBuilder.append(carry);
		return stringBuilder.reverse().toString();
	}

	public static void main(String[] args) {
		AddBinary addBinary = new AddBinary();
		Math.sqrt(8);
		System.out.println("Answer is :" + addBinary.addBinary("11", "1"));
		//System.out.println("Answer is :" + addBinary.addBinary("1010", "1011"));

	}

}
