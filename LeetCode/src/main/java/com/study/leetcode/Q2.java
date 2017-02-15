package com.study.leetcode;

import org.junit.Test;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself. 
 * Input: (2 -> 4 -> 3) 
 * 		+ (5 -> 6 -> 4) 
 * Output: 7 -> 0 -> 8
 * 342 + 465 = 798
 * 加法笔算的过程
 */
public class Q2 {
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode result = null;
        ListNode next = null;
        int carry = 0;
        do{
        	int sum = (null == l1? 0 : l1.val) 
        			+ (null == l2? 0 : l2.val);
        	int real = (sum + carry) % 10;
        	carry = (sum + carry) / 10;
        	if(null == result){
        		result = new ListNode(real);
        	}else if(null == next){
        		next = new ListNode(real);
        		result.next = next;
        	}else{
        		next.next = new ListNode(real);
        		next = next.next;
        	}
        	l1 = null == l1? null : l1.next;
        	l2 = null == l2? null : l2.next;
        	
        }while(null != l1 || null != l2 || carry != 0);
        return result;
    }
    
	@Test
	public void test() {
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
//		l1.next.next = new ListNode(3);
//		l1.next.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(6);
		
		ListNode result = Q2.addTwoNumbers(l1, l2);
		
		do{
			System.out.println(result.val);
			result = result.next;
		}while(null != result);
	}

}
