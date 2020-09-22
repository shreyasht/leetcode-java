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
		ListNode t1 = l1;
		ListNode t2 = l2;
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		int carry = 0;
		while (t1 != null || t2 != null) {
			int val1 = t1 != null ? t1.val : 0;
			int val2 = t2 != null ? t2.val : 0;
			int sum = val1 + val2 + carry;
			carry = sum / 10;
			sum = sum % 10;
			current.next = new ListNode(sum);
			current = current.next;
			if (t1 != null) {
				t1 = t1.next;
			}
			if (t2 != null) {
				t2 = t2.next;
			}
		}

		if (carry > 0) {
			current.next = new ListNode(carry);
		}

		return dummy.next;
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
		System.out.println(addTwoNumbers.addTwoNumbers(listNode, listNode4));
	}

}

