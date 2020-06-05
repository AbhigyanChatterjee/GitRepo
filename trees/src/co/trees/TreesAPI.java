package co.trees;

import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int value) {
		this.val = value;
		left = null;
		right = null;
	}
}
class BinaryTree {
	TreeNode root;
	void inorderTree(TreeNode node) {
		if(node == null) {
			return;
		}
		inorderTree(node.left);
		System.out.println(node.val);
		inorderTree(node.right);
	}
	void preorderTree(TreeNode node) {
		if(node == null) {
			return;
		}
		System.out.println(node.val);
		preorderTree(node.left);
		preorderTree(node.right);
	}
	void postorderTree(TreeNode node) {
		if(node == null) {
			return;
		}
		
		postorderTree(node.left);
		postorderTree(node.right);
		System.out.println(node.val);
	}
	void levelOrder(TreeNode node) {
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.add(node);
		while(qu.isEmpty() == false) {
			TreeNode temp = qu.poll();
			System.out.print(temp.val+ " ");
			if(temp.left != null) qu.add(temp.left);
			if(temp.right != null) qu.add(temp.right);
		}
	}
	void lineByLine(TreeNode node) {
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.add(node);
		qu.add(null);
		while(qu.size() > 1) {
			TreeNode temp = qu.poll();
			if(temp != null) {
				System.out.print(temp.val + " ");
			}
			if(temp == null) {
				System.out.println();
				qu.add(null);
				continue;
			}
			if(temp.left != null) qu.add(temp.left);
			if(temp.right != null) qu.add(temp.right);
		}
	}
	void lineByLine2(TreeNode node) {
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.add(node);
		while(qu.isEmpty() == false) {
			int count = qu.size();
			for(int i = 0; i < count; i++) {
				TreeNode temp = qu.poll();
				System.out.print(temp.val + " ");
				if(temp.left != null) qu.add(temp.left);
				if(temp.right != null) qu.add(temp.right);
			}
			System.out.println();
		}
	}
	int treeSize(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int leftSize = treeSize(node.left);
		int rightSize = treeSize(node.right);
		return leftSize + rightSize + 1;
	}
	int maxElement(TreeNode node) {
		if(node == null) return Integer.MIN_VALUE;
		return Math.max(node.val, Math.max(maxElement(node.left), maxElement(node.right)));
	}
	int height(TreeNode node) {
		if(node == null) return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		if(lheight > rheight) return lheight + 1;
		else return rheight + 1;
	}
	void printKth(TreeNode node, int k) {
		if(node == null) return;
		if(k == 0) {
			System.out.print(node.val + " ");
		}
		else {
			printKth(node.left, k - 1);
			printKth(node.right, k - 1);
		}
	}
	void leftView(TreeNode node) {
		leftViewUtil(node, 1);
	}
	final int maxlevel = 0;
	int maxlevel1 = maxlevel;
	int maxlevel2 = maxlevel;
	void leftViewUtil(TreeNode node, int level) {
		if(node == null) return;
		if(maxlevel2 < level) {
			System.out.print(node.val + " ");
			maxlevel1 = level;
		}
		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}
	void rightView(TreeNode node) {
		rightViewUtil(node , 1);
	}
	void rightViewUtil(TreeNode node, int level) {
		if(node == null) return;
		if(maxlevel2 < level) {
			System.out.print(node.val + " ");
			maxlevel2 = level;
		}
		rightViewUtil(node.right, level + 1);
		rightViewUtil(node.left, level + 1);
	}
	void leftView2(TreeNode node) {
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.add(node);
		while(qu.isEmpty() == false) {
			int count = qu.size();
			for(int i = 0; i < count; i++) {
				TreeNode temp = qu.poll();
				if(i == 0 ) System.out.print(temp.val + " ");
				if(temp.left != null) qu.add(temp.left);
				if(temp.right != null) qu.add(temp.right);
			}
		}
	}
	void rightView2(TreeNode node) {
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.add(node);
		while(qu.isEmpty() == false) {
			int count = qu.size();
			for(int i = 0; i < count; i++) {
				TreeNode temp = qu.poll();
				if(i == count - 1) System.out.print(temp.val + " ");
				if(temp.left != null) qu.add(temp.left);
				if(temp.right != null) qu.add(temp.right);
			}
		}
	}
	boolean treeSum(TreeNode node) {
//		if(node.left == null && node.right == null) return true;
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.add(node);
		while(qu.isEmpty() == false) {
			TreeNode temp = qu.poll();
			if(temp.left == null && temp.right == null) break;
			if(temp.left.val + temp.right.val != temp.val) {
				return false;
			}
			if(temp.left != null) qu.add(temp.left);
			if(temp.right != null) qu.add(temp.right);
		}
		return true;
	}
	boolean treeSum2(TreeNode node) {
		if(node == null) return true;
		if(node.left == null && node.right == null) return true;
		int sum = 0;
		if(node.left != null) sum += node.left.val;
		if(node.right != null) sum += node.right.val;
		return ((node.val == sum) && treeSum2(node.left) && treeSum2(node.right));
	}
	boolean isBalanced(TreeNode node) {
		if(node == null) return true;
		return (Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right));
	}
	boolean isBalanced2(TreeNode node) {
		return (isBalanced2Util(node) > 0);
	}
	int isBalanced2Util(TreeNode node) {
		if(node == null) return 0;
		int lh = isBalanced2Util(node.left);
		if(lh == -1) return -1;
		int rh = isBalanced2Util(node.right);
		if(rh == -1) return -1;
		if(Math.abs(lh - rh) > 1) return  -1;
		return Math.max(lh, rh) + 1;
	}
	int MaxWidth(TreeNode node) {
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		if(node == null) return 0;
		qu.add(node);
		int maxCount = Integer.MIN_VALUE;
		while(qu.isEmpty() == false) {
			int count = qu.size();
			maxCount = Math.max(maxCount, count);
			for(int i = 0; i < count;i++) {
				TreeNode temp = qu.poll();
				if(temp.left != null) qu.add(temp.left);
				if(temp.right != null) qu.add(temp.right);
			}
		}
		return maxCount;
	}
}
public class TreesAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		TreeNode root = new TreeNode(42);
		root.left = new TreeNode(9);
		root.right = new TreeNode(33);
		root.left.left = new TreeNode(2);
//		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(20);
		bt.inorderTree(root);
		System.out.println();
		bt.preorderTree(root);
		System.out.println();
		bt.postorderTree(root);
		bt.levelOrder(root);
		System.out.println();
		bt.lineByLine(root);
		System.out.println();
		bt.lineByLine2(root);
		System.out.println(bt.treeSize(root));
		System.out.println(bt.maxElement(root));
		System.out.println(bt.height(root));
		bt.printKth(root, 4);
		System.out.println();
		bt.leftView(root);
		System.out.println();
		bt.rightView(root);
		System.out.println();
		bt.leftView2(root);
		System.out.println();
		bt.rightView2(root);
		System.out.println();
		System.out.print(bt.treeSum2(root));
		System.out.println();
		System.out.print(bt.isBalanced(root));
		System.out.println();
		System.out.print(bt.isBalanced2(root));
		System.out.println();
		System.out.print(bt.MaxWidth(root));
		System.out.println();
		
		System.out.println();
	}

}
