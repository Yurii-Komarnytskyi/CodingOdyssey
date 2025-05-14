package neetcode.blind75.easy;

import java.util.Objects;

public class DiameterOfBinaryTree {
	// https://neetcode.io/problems/binary-tree-diameter

	private int maxDiameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		if (Objects.nonNull(root)) {
			maxDiameter = Math.max((findMaxNodeDepth(root.left) + findMaxNodeDepth(root.right)), maxDiameter);
			diameterOfBinaryTree(root.left);
			diameterOfBinaryTree(root.right);
		}
		return maxDiameter;
	}

	private int findMaxNodeDepth(TreeNode node) {
		boolean isNodeNull = Objects.isNull(node);
		int depth = (isNodeNull)? 0 : 1;
		int maxDepthOnLeft = 1;
		int maxDepthOnRight = 1;
		if (isNodeNull) {
			return depth; 
		} else {
			maxDepthOnLeft += findMaxNodeDepth(node.left);
			maxDepthOnRight += findMaxNodeDepth(node.right);
			depth = Math.max(maxDepthOnLeft, maxDepthOnRight);
		}
		return depth;
	}
}
