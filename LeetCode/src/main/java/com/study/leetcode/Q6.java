package com.study.leetcode;

import junit.framework.Assert;

import org.junit.Test;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 *	P   A   H   N              
 *	A P L S I I G
 *	Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Q6 {

	// find the regular
	public String convert(String s, int numRows) {
		if(numRows == 1){
			return s;
		}
		int length =  s.length();
		StringBuffer sb = new StringBuffer();
		// regular expression
		int step = 2 * numRows - 2;
		for(int i = 0; i < numRows; i++){
			for(int j = i; j < length; j += step){
				sb.append(s.charAt(j));
				// not the start and end
				if(i > 0 && i < numRows - 1){
					// middle regular expression
					int next = j + 2 * (numRows - i) - 2;
					if(next < length){
						sb.append(s.charAt(next));
					}
				}
			}
		}
		return sb.toString();
    }
	@Test
	public void test() {
		Assert.assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
		Assert.assertEquals("A", convert("A", 1));
	}

}
