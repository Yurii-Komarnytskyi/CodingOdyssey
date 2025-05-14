package neetcode.blind75.easy;

public class ReverseLinkedList {
	// https://neetcode.io/problems/reverse-a-linked-list

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode tail = head;
		ListNode currentListNode = head.next;
		head.next = null;
		while (currentListNode != null) {
			ListNode nextListNode = currentListNode.next;
			currentListNode.next = tail;
			tail = currentListNode;
			currentListNode = nextListNode;
		}
		return tail;
	}

}


