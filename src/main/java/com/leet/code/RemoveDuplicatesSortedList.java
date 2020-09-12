package com.leet.code;

/* https://leetcode.com/problems/remove-duplicates-from-sorted-list/ */

public class RemoveDuplicatesSortedList {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = head;
		while (nextNode != null && nextNode.next != null ) {
			if (nextNode.val == nextNode.next.val) {
				nextNode.next = nextNode.next.next;
			} else {
				nextNode = nextNode.next;
			}
		}

		return head;

	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		ListNode listNode2 = new ListNode(1);
		ListNode listNode3 = new ListNode(1);

		listNode.next = listNode2;
		listNode2.next = listNode3;


		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(4);
		ListNode listNode6 = new ListNode(6);

		listNode4.next = listNode5;
		listNode5.next = listNode6;

		ListNode listNode7 = new ListNode(1);
		ListNode listNode8 = new ListNode(1);
		ListNode listNode9 = new ListNode(2);
		ListNode listNode10 = new ListNode(3);
		ListNode listNode11 = new ListNode(3);

		listNode7.next = listNode8;
		listNode8.next = listNode9;
		listNode9.next = listNode10;
		listNode10.next = listNode11;


		RemoveDuplicatesSortedList removeDuplicatesSortedList = new RemoveDuplicatesSortedList();
		System.out.println(removeDuplicatesSortedList.deleteDuplicates(listNode));
		/*System.out.println(removeDuplicatesSortedList.deleteDuplicates(listNode4));
		System.out.println(removeDuplicatesSortedList.deleteDuplicates(listNode3));
		System.out.println(removeDuplicatesSortedList.deleteDuplicates(listNode7));
		System.out.println(removeDuplicatesSortedList.deleteDuplicates(listNode2));*/
	}

}
