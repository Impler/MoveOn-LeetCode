package com.study.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * 
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class Q4 {

	// 一般解法
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
		List<Integer> list = new ArrayList<Integer>();
		for(int n : nums1){
			list.add(n);
		}
		for(int n : nums2){
			list.add(n);
		}
		Collections.sort(list);
		int len = nums1.length + nums2.length;
		int middle = len / 2;
		if(len % 2 == 0){
			return (double)(list.get(middle) + list.get(middle - 1)) / 2;
		}else{
			return (double)list.get(middle);
		}
    }

	//TODO 较优解
	
	@Test
	public void test() {
		int[] nums1 = {1,2,3,4};
		int[] nums2 = {5,5,6};
		Assert.assertEquals(4.0, Q4.findMedianSortedArrays(nums1, nums2));
	}

}
