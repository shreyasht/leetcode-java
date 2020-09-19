package com.leet.code;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> intMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (intMap.containsKey(nums[i])) {
				int count = intMap.get(nums[i]);
				count = count + 1;
				intMap.put(nums[i], count);
			} else {
				intMap.put(nums[i], 1);
			}
		}
		for (int i : intMap.keySet()) {
			if (intMap.get(i) > nums.length / 2) {
				return i;
			}
		}
		return 0;
	}


	public int majorityElementRec(int nums[]) {
		return major(0, nums.length - 1, nums);
	}

	int count(int l, int h, int[] nums, int num) {
		int count = 0;
		for (int i = l; i <= h; i++) {
			if (num == nums[i]) {
				count = count + 1;
			}
		}
		return count;
	}

	int major(int l, int h, int[] nums) {

		if (l == h) {
			return nums[l];
		}
		int mid = l+ (h - l) / 2;

		int left = major(l, mid, nums);
		int right = major(mid+1, h, nums);

		if (left == right) {
			return left;
		}
		int leftCount = count(l, h, nums, left);
		int rightCount = count(l, h, nums, right);

		if (leftCount > rightCount) {
			return left;
		} else {
			return right;
		}
	}


	public static void main(String[] args) {
		MajorityElement majorityElement = new MajorityElement();
		int[] arr = {2, 2, 1, 1, 1, 2, 2};
		System.out.println(majorityElement.majorityElementRec(arr));
		System.out.println(majorityElement.majorityElement(arr));
	}
}
