package com.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice. Example:
 * Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 =
 * 9, return [0, 1]. Subscribe to see which companies asked this question.
 * 
 * public int[] twoSum(int[] nums, int target) {
 * 
 * }
 */
public class Q1 {

	public static int[] twoSumByHashMapWithTwoLoop(int[] nums, int target) {
		if (null == nums || nums.length == 0) {
			return null;
		}
		HashMap<Integer, Integer> buffMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			buffMap.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			Integer anotherNumIndex = buffMap.get(target - nums[i]);
			if (null != anotherNumIndex && anotherNumIndex != i) {
				return new int[] { i, anotherNumIndex };
			}
		}
		return null;
	}

	public static int[] twoSumByHashMapWithOneLoop(int[] nums, int target) {
		if (null == nums || nums.length == 0) {
			return null;
		}
		HashMap<Integer, Integer> buffMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer anotherNumIndex = buffMap.get(target - nums[i]);
			if (null == anotherNumIndex) {
				buffMap.put(nums[i], i);
			}else{
				return new int[]{anotherNumIndex, i};
			}
		}
		return null;
	}
	@Test
	public void testTwoSumByHashMapWithTwoLoop() {
		int[] results = Q1.twoSumByHashMapWithTwoLoop(new int[] { 7, 3, 4, 2, 9, 5 }, 14);
		System.out.print(Arrays.toString(results));
	}
	
	@Test
	public void testTwoSumByHashMapWithOneLoop() {
		int[] results = Q1.twoSumByHashMapWithOneLoop(new int[] { 7, 3, 4, 2, 9, 5 }, 14);
		System.out.print(Arrays.toString(results));
	}
}
