package com.leet.code;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return new ListNode();
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		int addVal = l1.val = l2.val;
		int carry=0;
		if(addVal>10){
			carry = addVal/10;
			addVal = addVal%10;
		}


		return null;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(2);
		ListNode listNode2 = new ListNode(4);
		ListNode listNode3 = new ListNode(3);


		listNode.next = listNode2;
		listNode2.next = listNode3;


		ListNode listNode4 = new ListNode(5);
		ListNode listNode5 = new ListNode(6);
		ListNode listNode6 = new ListNode(4);

		listNode4.next = listNode5;
		listNode5.next = listNode6;

		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		addTwoNumbers.addTwoNumbers(listNode, listNode4);
	}

}
