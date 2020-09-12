package com.leet.code;

/* https://leetcode.com/problems/implement-strstr/ */

public class ImplementStrStr {

	public int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0) {
			return 0;
		}
		if (haystack == null || haystack.length() == 0) {
			return -1;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}
		if (needle.equals(haystack)) {
			return 0;
		}

		char[] str = haystack.toCharArray();

		for (int i = 0; i < haystack.length(); i++) {
			if (i + needle.length() <= haystack.length()) {
				String needleWord = String.copyValueOf(str, i, needle.length());
				if (needleWord.equals(needle)) {
					return i;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		ImplementStrStr implementStrStr = new ImplementStrStr();
		implementStrStr.strStr("aaa", "a");
	}
}
