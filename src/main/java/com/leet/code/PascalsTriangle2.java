package com.leet.code;

import java.math.BigDecimal;
import java.util.*;

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
		//PascalsTriangle2 pascalsTriangle2 = new PascalsTriangle2();
		//System.out.println(pascalsTriangle2.getRow(3));
		//System.out.println(pascalsTriangle2.getRow(0));

		PhoneNumber phoneNumber = new PhoneNumber("000","111","222");
		PhoneNumber phoneNumber1 = phoneNumber.clone();

		Map<PhoneNumber,String> pMap = new HashMap<>();
		pMap.put(phoneNumber,"Jenny");

		System.out.println(pMap.get(phoneNumber1));

		BigDecimal bd1 = new BigDecimal("1.0");
		BigDecimal bd2 = new BigDecimal("1.00");

		Set<BigDecimal> decimalSet = new HashSet<>();
		decimalSet.add(bd1);
		decimalSet.add(bd2);

		System.out.println(decimalSet.size());

		Set<BigDecimal> decimalTreeSet = new TreeSet<>();
		decimalTreeSet.add(bd1);
		decimalTreeSet.add(bd2);

		System.out.println(decimalTreeSet.size());

	}
}
