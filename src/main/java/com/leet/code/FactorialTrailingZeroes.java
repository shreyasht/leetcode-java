package com.leet.code;

public class FactorialTrailingZeroes {

	/* https://www.youtube.com/watch?v=wkvVdggCSeo */

	public int trailingZeroes(int n) {
		int count = 0;
		while (n != 0) {
			int tmp = n / 5;
			count += tmp;
			n = tmp;
		}
		return count;
	}

	int fact(int n) {
		if (n == 0) {
			return 1;
		}

		return n * fact(n - 1);
	}

	public static void main(String[] args) {
		FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
		System.out.println(factorialTrailingZeroes.trailingZeroes(Integer.MAX_VALUE));
		/*System.out.println(factorialTrailingZeroes.trailingZeroes(6));
		System.out.println(factorialTrailingZeroes.trailingZeroes(10));
		System.out.println(factorialTrailingZeroes.trailingZeroes(25));*/
	}
}
