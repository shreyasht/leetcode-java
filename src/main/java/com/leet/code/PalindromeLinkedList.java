package com.leet.code;

import java.util.ArrayDeque;
import java.util.Queue;

public class PalindromeLinkedList {

	// Takes too much memory and time
	public boolean isPalindrome(ListNode head) {
		Queue<Integer> stack = new ArrayDeque<>();
		ListNode current = head;
		ListNode previous = null;
		while (current != null) {
			stack.add(current.val);
			ListNode temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}

		System.out.println(stack);
		System.out.println(previous);
		while (previous != null) {
			if (previous.val != stack.remove()) {
				return false;
			}
			previous = previous.next;
		}

		return true;
	}

	public boolean isPalindromeBetter(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		fast = head;
		slow = reverse(slow);

		while (slow != null) {
			if (fast.val != slow.val) {
				return false;
			}

			slow = slow.next;
			fast = fast.next;
		}

		return true;
	}

	ListNode reverse(ListNode slow) {
		ListNode current = slow;
		ListNode previous = null;
		while (current != null) {
			ListNode temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		return previous;
	}

	public static void main(String[] args) {
		PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

		ListNode listNode = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(1);

		listNode.next = listNode2;
		listNode2.next = listNode3;

		System.out.println(palindromeLinkedList.isPalindromeBetter(listNode));
	}
}
