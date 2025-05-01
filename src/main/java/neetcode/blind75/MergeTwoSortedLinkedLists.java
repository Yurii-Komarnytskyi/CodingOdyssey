package neetcode.blind75;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeTwoSortedLinkedLists {
//	https://neetcode.io/problems/merge-two-sorted-linked-lists
	
	private List<ListNode> sortedNodes = new ArrayList<>();

	public ListNode mergeTwoLists(ListNode nodeA, ListNode nodeB) {
		if (nodeA == null) {
			return nodeB;
		} else if (nodeB == null) {
			return nodeA;
		} 

		populateAndSortListNodes(List.of(nodeA, nodeB));
		ListNode mergedHead = sortedNodes.get(0);
		ListNode nextNode = mergedHead;
		
		for (Iterator<ListNode> iterator = sortedNodes.iterator(); iterator.hasNext();) {
			nextNode = nextNode.next = iterator.next() ;
		}
		
		return mergedHead;
	}
	
	private  void populateAndSortListNodes(List<ListNode> nodes) {
		ListNode nextListNode = null;
		for(ListNode node : nodes) {
			if(node != null ) {
				sortedNodes.add(new ListNode(node.val));
				nextListNode = node.next;
				while (nextListNode != null) {
					sortedNodes.add(new ListNode(nextListNode.val));
					nextListNode = nextListNode.next;
				}
			}
		}
		sortedNodes.sort((a, b) -> Integer.compare(a.val, b.val));
	}
}
