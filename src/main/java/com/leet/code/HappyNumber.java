package com.leet.code;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	// Time limit exceeds. Sub optimal solution.
	public boolean isHappy(int n) {
		int sum = 0;
		String[] arr0 = String.valueOf(n).split("");
		for (int i = 0; i < arr0.length; i++) {
			sum = (int) (sum + Math.pow(Integer.parseInt(arr0[i]), 2));
		}

		while (sum != 1) {
			String[] arr = String.valueOf(sum).split("");
			int newSum = 0;
			for (int i = 0; i < arr.length; i++) {
				newSum = (int) (newSum + Math.pow(Integer.parseInt(arr[i]), 2));
			}
			if (sum == n) {
				return false;
			}
			sum = newSum;
		}
		return true;
	}

	// Somewhat better solution using hashet
	public boolean isHappyHashSet(int n) {
		Set<Integer> seen = new HashSet<>();
		int sum = 0;
		String[] arr0 = String.valueOf(n).split("");
		for (int i = 0; i < arr0.length; i++) {
			sum = (int) (sum + Math.pow(Integer.parseInt(arr0[i]), 2));
		}
		seen.add(sum);
		while (sum != 1) {
			String[] arr = String.valueOf(sum).split("");
			int newSum = 0;
			for (int i = 0; i < arr.length; i++) {
				newSum = (int) (newSum + Math.pow(Integer.parseInt(arr[i]), 2));
			}
			if (seen.contains(newSum)) {
				return false;
			}
			seen.add(newSum);
			sum = newSum;
		}
		return true;
	}


	public static void main(String[] args) {
		HappyNumber happyNumber = new HappyNumber();
		System.out.println(happyNumber.isHappyHashSet(19));
		System.out.println(happyNumber.isHappy(4));
		System.out.println(happyNumber.isHappyHashSet(2));
	}
}
