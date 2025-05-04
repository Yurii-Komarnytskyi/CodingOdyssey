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
	

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		
		System.out.println(tree.maxDepth(n1));
		
		
		
	}
}
