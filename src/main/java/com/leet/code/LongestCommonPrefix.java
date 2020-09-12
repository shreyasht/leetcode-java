package com.leet.code;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {

		StringBuilder prefix = new StringBuilder("");
		if (strs.length == 0) {
			return prefix.toString();
		}
		String firstWord = strs[0];

		String[] firstWordArray = firstWord.split("");
		boolean flags = false;
		for (int j = 0; j < firstWordArray.length; j++) {
			prefix.append(firstWordArray[j]);
			for (int i = 1; i < strs.length; i++) {
				if (!strs[i].startsWith(prefix.toString())) {
					prefix.deleteCharAt(prefix.length() - 1);
					flags = true;
					break;
				}
			}
			if (flags) {
				break;
			}
		}
		return prefix.toString();
	}


	public static void main(String[] args) {
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		String[] args2 = {"aa", "ab"};
		String[] args3 = {"flow", "float", "flout"};
		System.out.println(longestCommonPrefix.longestCommonPrefix(args2));
		System.out.println(longestCommonPrefix.longestCommonPrefix(args3));

	}

}
