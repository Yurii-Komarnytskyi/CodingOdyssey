package neetcode.blind75;

public class InvertBinaryTree {
	// https://neetcode.io/problems/invert-a-binary-tree
	public TreeNode invertTree(TreeNode root) {
		return invertNodesRecursively(root);
	}

	private static TreeNode invertNodesRecursively(TreeNode node) {
		if(node == null) {
			return node;
		}

		TreeNode centralNode = node;
		if(centralNode.left == null && centralNode.right == null) {
			return centralNode;
		} else {
			TreeNode formerLeftNode = centralNode.left;
			TreeNode formerRightNode = centralNode.right;

			centralNode.left = invertNodesRecursively(formerRightNode);
			centralNode.right = invertNodesRecursively(formerLeftNode);
			return centralNode;
		}
	}
}
