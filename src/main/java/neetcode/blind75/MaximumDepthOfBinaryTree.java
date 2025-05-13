package neetcode.blind75;

import java.util.Objects;

public class MaximumDepthOfBinaryTree {
	// https://neetcode.io/problems/depth-of-binary-tree
	public int maxDepth(TreeNode root) {
		return findMaxDepthRecursively(root);
	}
	
	private static int findMaxDepthRecursively(TreeNode root) {
		boolean isRootNull = Objects.isNull(root);
		int result = (isRootNull)? 0 : 1;
		int maxDepthOnLeft = 1;
		int maxDepthOnRight = 1;
		if (isRootNull) {
			return result; 
		} else {
			maxDepthOnLeft += findMaxDepthRecursively(root.left);
			maxDepthOnRight += findMaxDepthRecursively(root.right);
			result = Math.max(maxDepthOnLeft, maxDepthOnRight);
		}
		return result;
	}
}
