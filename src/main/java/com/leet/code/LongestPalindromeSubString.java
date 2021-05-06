package com.leet.code;

public class LongestPalindromeSubString {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("cbbd"));
	}

	public static String longestPalindrome(String s) {

		boolean dp[][] = new boolean[s.length()][s.length()];
		int start =0;
		int len =0;

		for(int g=0;g<s.length();g++){

			for(int i=0, j=g;j<s.length();i++,j++){

				if(g==0){
					dp[i][j]=true;
				} else if(g==1){
					if(s.charAt(i)==s.charAt(j)){
						dp[i][j]=true;
						start =i;
						len =2;
					}else{
						dp[i][j]=false;
					}
				} else{
					if(((s.charAt(i)==s.charAt(j)) && dp[i+1][j-1])){
						start =i;
						len=g+1;
						dp[i][j]=true;
					} else{
						dp[i][j]=false;
					}
				}
			}

		}

		return s.substring(start,start+len);
	}

}
