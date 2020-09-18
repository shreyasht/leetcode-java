package com.leet.code;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode traverseA = headA;
		ListNode traverseB = headB;

		while (traverseA != traverseB) {
			if (traverseA == null) {
				traverseA = headB;
			} else {
				traverseA = traverseA.next;
			}

			if (traverseB == null) {
				traverseB = headA;
			} else {
				traverseB = traverseB.next;
			}
		}
		return traverseA;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(4);
		ListNode listNode2 = new ListNode(1);
		ListNode listNode3 = new ListNode(8);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);

		listNode.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;


		ListNode listNode6 = new ListNode(5);
		ListNode listNode7 = new ListNode(6);
		ListNode listNode8 = new ListNode(1);

		listNode6.next = listNode7;
		listNode7.next = listNode8;
		listNode8.next = listNode3;

		IntersectionOfTwoLinkedLists intersection = new IntersectionOfTwoLinkedLists();
		System.out.println(intersection.getIntersectionNode(listNode, listNode6));

	}
}
