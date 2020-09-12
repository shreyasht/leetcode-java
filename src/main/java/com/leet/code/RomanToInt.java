package com.leet.code;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	public int romanToInt(String s) {
		Map<String, Integer> romanMap = new HashMap<>();
		romanMap.put("I", 1);
		romanMap.put("V", 5);
		romanMap.put("X", 10);
		romanMap.put("L", 50);
		romanMap.put("C", 100);
		romanMap.put("D", 500);
		romanMap.put("M", 1000);


		String[] stringArray = s.split("");
		int total = 0;
		for (int i = 0; i < stringArray.length; i++) {
			String var = stringArray[i];
			int j = i + 1;
			if (var.equals("I") && j < stringArray.length) {
				String var2 = stringArray[j];
				if (var2.equals("V")) {
					total = total + 4;
					i = i + 1;
				} else if (var2.equals("X")) {
					total = total + 9;
					i = i + 1;
				} else {
					total = total + 1;
				}
			} else if (var.equals("X") && j < stringArray.length) {
				String var2 = stringArray[j];
				if (var2.equals("L")) {
					total = total + 40;
					i = i + 1;
				} else if (var2.equals("C")) {
					total = total + 90;
					i = i + 1;
				} else {
					total = total + 10;
				}
			} else if (var.equals("C") && j < stringArray.length) {
				String var2 = stringArray[j];
				if (var2.equals("D")) {
					total = total + 400;
					i = i + 1;
				} else if (var2.equals("M")) {
					total = total + 900;
					i = i + 1;
				} else {
					total = total + 100;
				}
			} else {
				total = total + romanMap.get(var);
			}
		}
		return total;
	}

	public static void main(String[] args) {
		RomanToInt romanToInt = new RomanToInt();
		System.out.println("Total is :" + romanToInt.romanToInt("XXVII"));
	}
}
