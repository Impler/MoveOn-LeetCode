package com.study.leetcode;

import org.junit.Test;
/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */
public class Q5 {

    public static String longestPalindrome(String s) {
    	if(null == s || s.length() == 0){
    		return null;
    	}
    	int pre = -1;
    	int next = -1;
    	int length = s.length();
    	String result = null;
    	for(int i = 0; i < length; i++){
    		pre = i - 1;
    		next = i + 1;
    		if(pre < 0){
    			result = String.valueOf(s.charAt(0));
    		}else{
	    		while(pre >= 0 && next < length){
	    			
	    			if(s.charAt(pre) == s.charAt(i)){
	    				
	    			}else if (s.charAt()){
	    				
	    			}
	    		}
    		}
    	}
    	return null;
    }
    
	@Test
	public void test() {

	}

}
