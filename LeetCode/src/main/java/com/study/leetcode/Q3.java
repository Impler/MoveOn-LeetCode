package com.study.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Q3 {

	// my answer
	public static int lengthOfLongestSubstring(String s) {
		if(null == s || s.length() == 0){
			return 0;
		}
		LinkedList<Character> candidate = new LinkedList<Character>();
		int maxLength = 0;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(candidate.contains(c)){
				int index = candidate.indexOf(c);
				while(index-- >= 0){
					candidate.removeFirst();
				}
			}
			candidate.add(c);
			maxLength = Math.max(candidate.size(), maxLength);
		}
        return maxLength;
    }
	
	// another answer
	// 使用区间滑块，[i,j)
	public static int lengthOfLongestSubstring1(String s){
		int maxLength = 0;
		int len = s.length();
		List<Character> list = new ArrayList<Character>();
		int start = 0;
		int end = 0;
		while(start < len && end < len){
			if(!list.contains(s.charAt(end))){
				list.add(s.charAt(end));
				end++;
				maxLength = Math.max(maxLength, end - start);
			}else{
				list.remove((Character)s.charAt(start));
				start++;
			}
		}
		return maxLength;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(1, Q3.lengthOfLongestSubstring("aaaaa"));
		Assert.assertEquals(4, Q3.lengthOfLongestSubstring("abcdabad"));
		Assert.assertEquals(10, Q3.lengthOfLongestSubstring("d123456789"));
		Assert.assertEquals(5, Q3.lengthOfLongestSubstring("asdiioasd"));
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(1, Q3.lengthOfLongestSubstring1("aaaaa"));
		Assert.assertEquals(4, Q3.lengthOfLongestSubstring1("abcdabad"));
		Assert.assertEquals(10, Q3.lengthOfLongestSubstring1("d123456789"));
		Assert.assertEquals(5, Q3.lengthOfLongestSubstring1("asdiioasd"));
	}
}
