package com.leet.code;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		while (head != null) {
			if (head.val != val) {
				current.next = new ListNode(head.val);
				current = current.next;
			}
			head = head.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(6);
		ListNode listNode4 = new ListNode(3);
		ListNode listNode5 = new ListNode(4);
		ListNode listNode6 = new ListNode(5);
		ListNode listNode7 = new ListNode(6);

		listNode.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = listNode7;


		RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
		System.out.println(removeLinkedListElements.removeElements(listNode, 6));
	}

}
