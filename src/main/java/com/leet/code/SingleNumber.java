package com.leet.code;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {

	/* Using maths
	 * 2X(a+b+c)−(a+a+b+b+c)=c
	 *
	 * Another technique using XOR
	 */

	public int singleNumber(int[] nums) {
		int a = 0;
		for (int i : nums) {
			a = a ^ i;
		}
		return a;
	}

	public static void main(String[] args) {
		/*SingleNumber singleNumber = new SingleNumber();
		int[] arr = {4, 1, 2, 1, 2};
		int[] arr2 = {2, 2, 1};
		//System.out.println(singleNumber.singleNumber(arr));
		System.out.println(singleNumber.singleNumber(arr2));*/
		Character c = '3';
		int k = 0;
		k = k * 10 + c - '0';

		System.out.println(k);
		System.out.println(Character.getNumericValue(c));
		System.out.println(neighbors("0001"));
		printReverse("abc".toCharArray());
	}

	private static void printReverse(char [] str) {
		helper(0, str);
	}

	private static void helper(int index, char [] str) {
		if (str == null || index >= str.length) {
			return;
		}
		helper(index + 1, str);
		System.out.print(str[index]);
	}


	static List<String> neighbors(String code) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int x = code.charAt(i) - '0';
			for (int diff = -1; diff <= 1; diff += 2) {
				int y = (x + diff + 10) % 10;
				result.add(code.substring(0, i) + ("" + y) + code.substring(i + 1));
			}
		}
		return result;
	}
}
