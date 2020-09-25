package com.leet.code;

import java.util.Arrays;

public class HouseRobber {

	int[] cache;

	public int rob(int[] nums) {
		cache = new int[nums.length + 1];
		Arrays.fill(cache, -1);
		return robs(nums, nums.length - 1);
	}

	// Time limit exceeds
	int robsRec(int[] nums, int i) {
		if (i < 0) {
			return 0;
		}
		return Math.max((robsRec(nums, i - 2) + nums[i]), robsRec(nums, i - 1));
	}

	//O(n) recursive solution
	int robs(int[] nums, int i) {
		if (i < 0) {
			return 0;
		}

		if (cache[i] != -1) {
			return cache[i];
		}

		return cache[i] = Math.max((robs(nums, i - 2) + nums[i]), robs(nums, i - 1));
	}

	int robs(int[] nums) {
		if(nums==null || nums.length==0){
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
		int[] cacheNew = new int[nums.length + 1];
		cacheNew[0] = nums[0];
		cacheNew[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			cacheNew[i] = Math.max((cacheNew[i - 2] + nums[i]), cacheNew[i - 1]);
		}
		return cacheNew[nums.length - 1];
	}

	// Most efficient solution
	int robsEff(int[] nums) {
		if(nums==null || nums.length==0){
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
		int prev2 = nums[0];
		int prev1 = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			int temp = prev1;
			prev1 = Math.max(nums[i] + prev2, prev1);
			prev2 = temp;
		}
		return prev1;
	}

	public static void main(String[] args) {
		int[] arr = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
		HouseRobber houseRobber = new HouseRobber();
		System.out.println(houseRobber.robsEff(arr));
	}
}
