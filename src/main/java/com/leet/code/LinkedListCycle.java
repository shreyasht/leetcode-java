package com.leet.code;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head.next.next;
		while (fast != slow) {
			if (fast == null || fast.next == null) {
				return false;
			}

			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(3);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(0);
		ListNode listNode4 = new ListNode(4);

		listNode.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode2;

		ListNode listNode5 = new ListNode(5);

		LinkedListCycle linkedListCycle = new LinkedListCycle();
		System.out.println(linkedListCycle.hasCycle(listNode));
		System.out.println(linkedListCycle.hasCycle(listNode5));
	}
}
