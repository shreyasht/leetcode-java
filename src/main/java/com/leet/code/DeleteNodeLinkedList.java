package com.leet.code;

public class DeleteNodeLinkedList {

	public void deleteNode(ListNode node) {
		ListNode current = node;
		while (current != null && current.next != null) {
			int temp = current.next.val;
			current.next.val = current.val;
			current.val = temp;
			if (current.next.next == null) {
				current.next = null;
			} else {
				current = current.next;
			}
		}
	}


	public static void main(String[] args) {
		ListNode listNode = new ListNode(4);
		ListNode listNode2 = new ListNode(5);
		ListNode listNode3 = new ListNode(1);
		ListNode listNode4 = new ListNode(9);


		listNode.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		new DeleteNodeLinkedList().deleteNode(listNode2);

		System.out.println(listNode);
	}
}
