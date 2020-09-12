package com.leet.code;

/* https://leetcode.com/problems/length-of-last-word */

public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		if(s==null || s.isEmpty() || s.trim().isEmpty()){
			return 0;
		}
		String [] array= s.split(" ");
		if(array.length==1){
			return array[0].length();
		}
		return array[array.length-1].length();
	}

	public static void main(String[] args) {
		LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
		System.out.println("Length is: " + lengthOfLastWord.lengthOfLastWord("      "));
	}

}
