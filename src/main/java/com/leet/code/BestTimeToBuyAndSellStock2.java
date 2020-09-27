package com.leet.code;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {

	public int maxProfit(int[] prices) {

		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit = profit + (prices[i] - prices[i - 1]);
			}
		}

		return profit;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock2();
		int[] arr = {7, 1, 5, 3, 6, 4};
		int[] arr2 = {7, 6, 4, 3, 1};
		int[] arr3 = {2, 4, 1};
		int[] arr4 = {2, 1, 2, 1, 0, 1, 2};
		System.out.println(Arrays.toString(arr) + " " + bestTimeToBuyAndSellStock.maxProfit(arr));
		System.out.println("----------------------------------");
		System.out.println(Arrays.toString(arr2) + " " + bestTimeToBuyAndSellStock.maxProfit(arr2));
		System.out.println("----------------------------------");
		System.out.println(Arrays.toString(arr3) + " " + bestTimeToBuyAndSellStock.maxProfit(arr3));
		System.out.println("----------------------------------");
		System.out.println(Arrays.toString(arr4) + " " + bestTimeToBuyAndSellStock.maxProfit(arr4));
	}
}
