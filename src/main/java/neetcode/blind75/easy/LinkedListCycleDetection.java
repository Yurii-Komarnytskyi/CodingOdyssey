package neetcode.blind75.easy;

public class LinkedListCycleDetection {
	// https://neetcode.io/problems/linked-list-cycle-detection
	public boolean hasCycle(ListNode head) {
		boolean result = false;

		if(head == null || head.next == null) {
			return result;			
		} else {
			ListNode slowPointer = head;
			ListNode fastPointer = head.next;
			while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
				if(fastPointer.next == slowPointer) {
					result = true;
					break;
				}
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next.next;
				
			}
			return result;
		}
	}
}
