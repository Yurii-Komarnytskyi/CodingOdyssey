package neetcode.blind75;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleDetection {

	public boolean hasCycle(ListNode head) {
		boolean result = false;

		if(head == null || head.next == null) {
			return result;			
		} else {
			Set<ListNode> priorNodes = new HashSet<>();
			ListNode nextNode = head;

			while (nextNode != null) {
				priorNodes.add(nextNode);
				if(nextNode.next != null && priorNodes.contains(nextNode.next)) {
					result = true;
					break;
				}
				nextNode = nextNode.next;
			}
			return result;
		}
	}
}
