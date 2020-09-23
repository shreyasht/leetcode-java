package com.leet.code;

import java.util.Arrays;

public class RotateArray {

	public void rotate(int[] nums, int k) {
		int[] arr = new int[nums.length];
		for (int i = 1; i <= k; i++) {
			arr[0] = nums[nums.length - 1];
			for (int j = 0; j < nums.length - 1; j++) {
				arr[j + 1] = nums[j];
			}
			for (int l = 0; l < nums.length; l++) {
				nums[l] = arr[l];
			}
		}
	}

	// Time limit exceeds
	public void rotate2(int[] nums, int k) {
		k = k % nums.length;
		int temp, prev;
		for (int i = 0; i < k; k++) {
			prev = nums[nums.length - 1];
			for (int j = 0; j < nums.length; j++) {
				temp = nums[j];
				nums[j] = prev;
				prev = temp;
			}
		}
	}

	public void rotate3(int[] nums, int k) {
		int[] arr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[(i + k) % nums.length] = nums[i];
		}
		for (int j = 0; j < nums.length; j++) {
			nums[j] = arr[j];
		}
	}

	public void rotate4(int[] nums, int k) {
		k = k % nums.length;
		reverse(0, nums.length - 1, nums);
		reverse(0, k-1, nums);
		reverse(k, nums.length - 1 , nums);
	}

	private void reverse(int start, int end, int[] nums) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;

			start++;
			end--;
		}
	}


	public static void main(String[] args) {
		int[] arrr = {-1, -100, 3, 99};
		RotateArray rotateArray = new RotateArray();
		rotateArray.rotate4(arrr, 2);
		System.out.println(Arrays.toString(arrr));

	}
}
