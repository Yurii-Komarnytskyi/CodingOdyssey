package neetcode.blind75.easy;

import java.util.Objects;

public class BalancedBinaryTree {
	// https://neetcode.io/problems/balanced-binary-tree
	private boolean balanced = true;

	public boolean isBalanced(TreeNode root) {
		if (Objects.isNull(root)) {
			return balanced;
		} else {
			if (Math.abs(getTreeNodeDepth(root.left) - getTreeNodeDepth(root.right)) > 1) {
				balanced = false;
				return balanced;
			}
			isBalanced(root.left);
			isBalanced(root.right);
			return balanced;
		}
	}

	private int getTreeNodeDepth(TreeNode root) {
		int result = 1;
		int maxDepthOnLeft = 1;
		int maxDepthOnRight = 1;
		if (Objects.isNull(root)) {
			return result; 
		} else {
			maxDepthOnLeft += getTreeNodeDepth(root.left);
			maxDepthOnRight += getTreeNodeDepth(root.right);
			result = Math.max(maxDepthOnLeft, maxDepthOnRight);
		}
		return result;
	}
}
