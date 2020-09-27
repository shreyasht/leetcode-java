package com.leet.code;

public class ClimbingStairs {
	int[] cache;

	public int climbStairs(int n) {
		cache = new int[n + 1];
		return climbDp2(n);
	}

	// Time limit exceeds
	public int climb(int i, int n) {
		if (i > n) {
			return 0;
		}
		if (i == n) {
			return 1;
		}

		return climb(i + 1, n) + climb(i + 2, n);
	}

	// Time limit exceeds
	public int climbDp(int i, int n) {
		int[] cache = new int[n + 1];

		if (i > n) {
			return 0;
		}
		if (i == n) {
			return 1;
		}
		if (cache[i] > 0) {
			return cache[i];
		}

		return cache[i] = climbDp(i + 1, n) + climbDp(i + 2, n);
	}

	public int climbDp2(int n) {
		cache[1] = 1;
		cache[2] = 2;

		for (int j = 3; j <= n; j++) {
			cache[j] = cache[j - 1] + cache[j - 2];
		}
		return cache[n];
	}


	public static void main(String[] args) {
		ClimbingStairs climbingStairs = new ClimbingStairs();
		System.out.println(climbingStairs.climbStairs(44));
	}
}

