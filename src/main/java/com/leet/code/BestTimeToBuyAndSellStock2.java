package com.leet.code;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStock2 {

	public int maxProfit(int[] prices) {

		List<Integer> profitList = new ArrayList<>();
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else if ((prices[i] - minPrice) > maxProfit) {
				profitList.add((prices[i] - minPrice));
				maxProfit = 0;
				minPrice = Integer.MAX_VALUE;
			}
		}
		return profitList.stream().mapToInt(Integer::intValue).sum();
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock2();
		int[] arr = {7, 1, 5, 3, 6, 4};
		int[] arr2 = {7, 6, 4, 3, 1};
		int[] arr3 = {2, 4, 1};
		int[] arr4 = {1, 2, 3, 4, 5};
		System.out.println(bestTimeToBuyAndSellStock.maxProfit(arr));
		System.out.println(bestTimeToBuyAndSellStock.maxProfit(arr2));
		System.out.println(bestTimeToBuyAndSellStock.maxProfit(arr3));
		System.out.println(bestTimeToBuyAndSellStock.maxProfit(arr4));
	}
}
