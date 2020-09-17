package com.leet.code;

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
		SingleNumber singleNumber = new SingleNumber();
		int[] arr = {4, 1, 2, 1, 2};
		int[] arr2 = {2, 2, 1};
		//System.out.println(singleNumber.singleNumber(arr));
		System.out.println(singleNumber.singleNumber(arr2));
	}
}
