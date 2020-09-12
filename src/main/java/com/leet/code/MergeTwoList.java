package com.leet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*  https://leetcode.com/problems/merge-two-sorted-lists/ */

public class MergeTwoList {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		List<ListNode> integerList = new ArrayList<>();

		ListNode listNodeL1 = l1;
		do {
			integerList.add(listNodeL1);
			listNodeL1 = listNodeL1.next;
		} while (listNodeL1 != null);


		ListNode listNodeL2 = l2;
		do {
			integerList.add(listNodeL2);
			listNodeL2 = listNodeL2.next;
		} while (listNodeL2 != null);

		List<ListNode> sortedList = integerList.stream()
				.sorted(Comparator.comparingInt(l -> l.val))
				.collect(Collectors.toList());

		ListNode listNodeF = sortedList.get(0);

		for (int i = 1; i < sortedList.size(); i++) {
			ListNode listNode1 = sortedList.get(i);
			if (i < sortedList.size() - 1) {
				listNode1.next = sortedList.get(i + 1);
			}
			if (i == 1) {
				listNodeF.next = listNode1;
			}
		}
		return listNodeF;
	}

	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode mergeHead;
		if (l1.val < l2.val) {
			mergeHead = l1;
			mergeHead.next = mergeTwoLists2(l1.next, l2);
		} else {
			mergeHead = l2;
			mergeHead.next = mergeTwoLists2(l1, l2.next);
		}
		return mergeHead;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(7);

		listNode.next = listNode2;
		listNode2.next = listNode3;


		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(4);
		ListNode listNode6 = new ListNode(6);

		listNode4.next = listNode5;
		listNode5.next = listNode6;

		MergeTwoList mergeTwoList = new MergeTwoList();
		mergeTwoList.mergeTwoLists2(listNode, listNode4);
	}


}


class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
	}
}
