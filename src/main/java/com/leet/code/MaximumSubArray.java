package com.leet.code;

/* https://leetcode.com/problems/maximum-subarray */

public class MaximumSubArray {
	public int maxSubArray(int[] nums) {
		return maxSubArraySum(nums, 0, nums.length - 1);
	}

	private int maxSubArraySum(int[] arr, int l,
							   int h) {
		if (l == h)
			return arr[l];
		int m = (l + h) / 2;
		return Math.max(Math.max(maxSubArraySum(arr, l, m),
				maxSubArraySum(arr, m + 1, h)),
				crossingSum(arr, l, m, h));
	}

	private int crossingSum(int[] arr, int l,
                            int m, int h) {
		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		for (int i = m; i >= l; i--) {
			sum = sum + arr[i];
			if (sum > left_sum)
				left_sum = sum;
		}
		sum = 0;
		int right_sum = Integer.MIN_VALUE;
		for (int i = m + 1; i <= h; i++) {
			sum = sum + arr[i];
			if (sum > right_sum)
				right_sum = sum;
		}

		return Math.max(left_sum + right_sum, Math.max(left_sum, right_sum));
	}


	public static void main(String[] args) {
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		MaximumSubArray maximumSubArray = new MaximumSubArray();
		System.out.println("Answer is: " + maximumSubArray.maxSubArray(arr));
	}

}
