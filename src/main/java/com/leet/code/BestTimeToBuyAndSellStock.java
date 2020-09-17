package com.leet.code;

/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/*/

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else if ((prices[i] - minPrice) > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
		int[] arr = {7, 1, 5, 3, 6, 4};
		int[] arr2 = {7, 6, 4, 3, 1};
		int[] arr3 = {2, 4, 1};
		System.out.println(bestTimeToBuyAndSellStock.maxProfit(arr));
		System.out.println(bestTimeToBuyAndSellStock.maxProfit(arr2));
		System.out.println(bestTimeToBuyAndSellStock.maxProfit(arr3));
	}

}
