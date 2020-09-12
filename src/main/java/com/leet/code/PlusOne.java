package com.leet.code;

import java.util.Arrays;

public class PlusOne {

	public int[] plusOne(int[] digits) {

		int last = digits[digits.length - 1] + 1;
		int carry = 0;
		int value = 0;
		if (last >= 10) {
			value = last % 10;
			carry = last / 10;
			digits[digits.length - 1] = value;
			if(digits.length==1){
				int[] arr = new int[digits.length + 1];
				for (int j = digits.length - 1; j >= 0; j--) {
					arr[j] = digits[j];
				}
				arr[0] = carry;
				return arr;
			}
		} else {
			digits[digits.length - 1] = last;
		}
		for (int i = digits.length - 2; i >= 0; i--) {
			int val = 0;
			val = carry + digits[i];
			if (val >= 10) {
				value = last % 10;
				carry = last / 10;
				digits[i] = value;
				if (i == 0) {
					int[] arr = new int[digits.length + 1];
					for (int j = digits.length - 1; j >= 0; j--) {
						arr[j] = digits[j];
					}
					arr[0] = carry;
					return arr;
				}
			} else {
				carry = 0;
				digits[i] = val;
			}

		}

		return digits;
	}

	public static void main(String[] args) {
		int[] arr = {0};
		PlusOne plusOne = new PlusOne();
		System.out.println("Answer is: " + Arrays.toString(plusOne.plusOne(arr)));
	}

}
