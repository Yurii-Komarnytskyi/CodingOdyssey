package neetcode.blind75.easy;

import java.util.Objects;

public class SubtreeOfAnotherTree {
	// https://neetcode.io/problems/subtree-of-a-binary-tree 
	
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		return treeNodeToString(root).contains(treeNodeToString(subRoot));
	}
	
	private String treeNodeToString(TreeNode treeNode) {
		StringBuilder builder = new StringBuilder();
		if (Objects.isNull(treeNode)) {
			return "null";
		} else {
			builder.append(treeNode.val);
			builder.append(treeNodeToString(treeNode.left));
			builder.append(treeNodeToString(treeNode.right));
		}
		return builder.toString();
	}
}
