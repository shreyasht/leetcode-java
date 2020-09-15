package com.leet.code;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> returnList = new ArrayList<>();
		if (numRows == 0) {
			return returnList;
		}
		List<Integer> firstList = new ArrayList<>();
		firstList.add(1);
		returnList.add(firstList);
		for (int i = 1; i < numRows; i++) {
			List<Integer> intList = new ArrayList<>();
			// User same return list for storing the previous results.
			List<Integer> prevList = returnList.get(i - 1);
			intList.add(1);

			for (int j = 1; j < i; j++) {
				intList.add(prevList.get(j - 1) + prevList.get(j));
			}

			intList.add(1);

			returnList.add(intList);
		}
		return returnList;
	}


	public static void main(String[] args) {
		PascalsTriangle pascalsTriangle = new PascalsTriangle();
		for (List<Integer> intL : pascalsTriangle.generate(7)) {
			System.out.println(intL);
		}

	}

}
