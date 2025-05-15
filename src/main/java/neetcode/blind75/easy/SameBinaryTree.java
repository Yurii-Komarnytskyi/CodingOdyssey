package neetcode.blind75.easy;

import java.util.Objects;

public class SameBinaryTree {
	// https://neetcode.io/problems/same-binary-tree
	
	private boolean areTreesEqual = true;
	
	public boolean isSameTree(TreeNode a, TreeNode b) {
		if (Objects.isNull(a) && Objects.isNull(b)) {
			return areTreesEqual;
		} else if (Objects.isNull(a) ^ Objects.isNull(b) || a.val != b.val) {
			areTreesEqual = false;
			return areTreesEqual;
		}
		isSameTree(a.left, b.left);
		isSameTree(a.right, b.right);
		
		return areTreesEqual;
	}
}
