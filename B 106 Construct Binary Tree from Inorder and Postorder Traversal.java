//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
//根据中序和后序构造二叉树
//非递归解法 https://leetcode.com/discuss/94800/solutions-recursion-recursion-recursion-space-complexity
public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
	
	public TreeNode build(int[] inorder, int[] postorder, int istart, int iend, int pstart, int pend) {
		if(istart > iend || pstart > pend)
			return null;
		int inorderindex = 0;
		for(int i=istart, j=iend; i<=j; i++, j--) {
			if(inorder[i] == postorder[pend]) {
				inorderindex = i;
				break;
			}
			if(inorder[j] == postorder[pend]) {
				inorderindex = j;
				break;
			}
		}
		TreeNode root = new TreeNode(postorder[pend]);
		root.left = build(inorder, postorder, istart, inorderindex-1, pstart, pstart+inorderindex-istart-1);
		root.right = build(inorder, postorder, inorderindex+1, iend, pstart+inorderindex-istart, pend-1);
		return root;
	}
