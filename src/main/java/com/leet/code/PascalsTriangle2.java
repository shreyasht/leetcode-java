package com.leet.code;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> firstList = new ArrayList<>();
		for (int i = 0; i <= rowIndex; i++) {
			firstList.add(1);
			for (int j = i - 1; j > 0; j--) {
				firstList.set(j, firstList.get(j - 1) + firstList.get(j));
			}
		}
		return firstList;
	}

	public static void main(String[] args) {
		PascalsTriangle2 pascalsTriangle2 = new PascalsTriangle2();
		System.out.println(pascalsTriangle2.getRow(3));
		//System.out.println(pascalsTriangle2.getRow(0));
	}
}
