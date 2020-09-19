package com.leet.code;

public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		StringBuilder stringBuilder = new StringBuilder();
		while (n > 0) {
			n--;
			stringBuilder.insert(0, (char)(('A' + n % 26)));
			n = n / 26;
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
		System.out.println(excelSheetColumnTitle.convertToTitle(701));
		System.out.println(excelSheetColumnTitle.convertToTitle(0));
		System.out.println(excelSheetColumnTitle.convertToTitle(26));
		System.out.println(excelSheetColumnTitle.convertToTitle(28));
		System.out.println(excelSheetColumnTitle.convertToTitle(77));
		System.out.println(excelSheetColumnTitle.convertToTitle(113));
		System.out.println(excelSheetColumnTitle.convertToTitle(1013));
	}
}
