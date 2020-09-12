package com.leet.code;

/* https://leetcode.com/problems/merge-sorted-array/
 * https://www.youtube.com/watch?v=LXq6wnkkeNA
 * */

import java.util.Arrays;

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int k = nums1.length - 1;
		int i = m - 1;
		int j = n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				i--;
				k--;
			} else {
				nums1[k] = nums2[j];
				j--;
				k--;
			}
		}
		while (j >= 0) {
			nums1[k] = nums2[j];
			k--;
			j--;
		}
	}

	public static void main(String[] args) {
		MergeSortedArray mergeSortedArray = new MergeSortedArray();
		int[] nums1 = {4, 0, 0, 0, 0, 0};
		int[] nums2 = {1,2,3,5,6};
		mergeSortedArray.merge(nums1, 1, nums2, 5);
		System.out.println(Arrays.toString(nums1));
	}

}
