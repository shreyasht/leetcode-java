package com.leet.code;

import java.util.Stack;

public class ReverseLinkedList {

	// Iterative with more memory.
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		Stack<Integer> integerStack = new Stack<>();

		while (head != null) {
			integerStack.push(head.val);
			head = head.next;
		}

		ListNode start = new ListNode(0);
		ListNode returnVal = start;
		while (!integerStack.isEmpty()) {
			start.next = new ListNode(integerStack.pop());
			start = start.next;
		}

		return returnVal.next;
	}

	public ListNode reverseListNoMem(ListNode head) {
		ListNode current = head;
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
		ListNode listNode = new ListNode(2);
		ListNode listNode2 = new ListNode(4);
		ListNode listNode3 = new ListNode(3);


		listNode.next = listNode2;
		listNode2.next = listNode3;

		ReverseLinkedList r = new ReverseLinkedList();
		System.out.println(r.reverseListNoMem(listNode));
	}
}
