package com.study.leetcode;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000. 
 * Example: 
 * Input: "babad" 
 * Output: "bab"
 * Note: "aba" is also a valid answer. 
 * Example: 
 * Input: "cbbd" 
 * Output: "bb"
 */
public class Q5 {


	public static String longestPalindrome(String s){
		if(null == s){
			return null;
		}
		
		int length = s.length();
		if(length <= 1){
			return s;
		}
	
		String result = "";
		
		//TODO
		return result;
	}
	

	@Test
	public void test() {
		Assert.assertEquals("anana", Q5.longestPalindrome("bananas"));
		Assert.assertEquals("a", Q5.longestPalindrome("a"));
		Assert.assertEquals("bb", Q5.longestPalindrome("bb"));
		Assert.assertEquals("bbb", Q5.longestPalindrome("bbb"));
		Assert.assertEquals("bbbb", Q5.longestPalindrome("bbbb"));
		Assert.assertEquals("bbbbb", Q5.longestPalindrome("bbbbb"));
		Assert.assertEquals("a", Q5.longestPalindrome("abc"));
		Assert.assertEquals("bab", Q5.longestPalindrome("babad"));
		Assert.assertEquals("abcba", Q5.longestPalindrome("abcba"));
		Assert.assertEquals("abccba", Q5.longestPalindrome("abccba"));
		Assert.assertEquals("bb", Q5.longestPalindrome("abbc"));
		Assert.assertEquals("245542", Q5.longestPalindrome("1232455422"));
	}

}
