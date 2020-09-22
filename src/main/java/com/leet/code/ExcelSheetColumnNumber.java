package com.leet.code;

import java.util.stream.IntStream;

public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {

		char[] arr = s.toCharArray();
		int n = 0;
		for (int j = 0; j < arr.length; j++) {
			n = n * 26 + (arr[j] - 65 + 1);
		}

		return n;
	}

	public int titleToNumber2(String s) {
		return IntStream.range(0, s.length()).reduce(0, (result, i) -> result * 26 + (s.charAt(i) - 'A' + 1));
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
		System.out.println(excelSheetColumnNumber.titleToNumber2("A"));
		System.out.println(excelSheetColumnNumber.titleToNumber("AA"));
		System.out.println(excelSheetColumnNumber.titleToNumber("AB"));
		System.out.println(excelSheetColumnNumber.titleToNumber("ZA"));
		System.out.println(excelSheetColumnNumber.titleToNumber("ZABE"));
	}
}
