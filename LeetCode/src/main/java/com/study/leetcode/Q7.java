package com.study.leetcode;

import junit.framework.Assert;

import org.junit.Test;
/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321

 * Note:
 * The input is assumed to be a 32-bit signed integer. 
 * Your function should return 0 when the reversed integer overflows.
 */
public class Q7 {

	// solution 1 : low speed s
	public int reverseByStr(int x) {
        String str = String.valueOf(x);
        StringBuffer sb = new StringBuffer(str.length());
        for(int i = str.length() - 1; i >= 0; i--){
        	char c = str.charAt(i);
        	if(c == '0' && sb.length() == 0 && i != 0){
        		continue;
        	}else{
        		sb.append(c);
        	}
        }
        int result = 0;
        try {
			if(x >= 0){
				result = Integer.valueOf(sb.toString());
			}else{
				result = -1 * Integer.valueOf(sb.substring(0, sb.length()-1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
    }
	// solution 1 : low speed e
	
	// solution 2 s
	public int reverseByNum(int x) {
		
		int result = 0;
		int num = Math.abs(x);
		int last;
		double temp;
		while(num > 0){
			last = num % 10;
			temp = last * Math.pow(10, intSize(num)-1);
			// prevent integer overflows
			if(temp >= Integer.MAX_VALUE || (temp + result) > Integer.MAX_VALUE){
				return 0;
			}
			
			result += (int)temp;
			
			num = num / 10;
		}
		if(x < 0){
			result *= -1;
		}
		return result;
    }
	
	int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,    
			99999999, 999999999, Integer.MAX_VALUE};
	
	public int intSize(int num){
		for(int i=0; i<sizeTable.length; i++){
			if(num <= sizeTable[i]){
				return i+1;
			}
		}
		return 0;
	}
	// solution 2 e
	
	
	// solution 3 s
	public int reverseByNum3(int x) {
		
		int result = 0;
		int last;
		while(x != 0){
			last = x % 10;
			result = result * 10 + last;
			//todo
			if(result % 10 != last || result / 10 )
			x = x / 10;
		}
		return result;
    }
	// solution 3 e
	
	
	@Test
	public void testByStr() {
		Assert.assertEquals(0, reverseByStr(0));
		Assert.assertEquals(1, reverseByStr(1));
		Assert.assertEquals(1, reverseByStr(10));
		Assert.assertEquals(-21, reverseByStr(-12));
		Assert.assertEquals(0, reverseByStr(1000000003));
		Assert.assertEquals(0, reverseByStr(1563847412));
	}
	@Test
	public void testByNum() {
		Assert.assertEquals(0, reverseByNum(0));
		Assert.assertEquals(1, reverseByNum(1));
		Assert.assertEquals(1, reverseByNum(10));
		Assert.assertEquals(-21, reverseByNum(-12));
		Assert.assertEquals(0, reverseByNum(1000000003));
		Assert.assertEquals(0, reverseByNum(1563847412));
	}
	@Test
	public void testByNum3() {
		Assert.assertEquals(0, reverseByNum3(0));
		Assert.assertEquals(1, reverseByNum3(1));
		Assert.assertEquals(1, reverseByNum3(10));
		Assert.assertEquals(-21, reverseByNum3(-12));
		Assert.assertEquals(0, reverseByNum3(1000000003));
		Assert.assertEquals(0, reverseByNum(1563847412));
	}

}
