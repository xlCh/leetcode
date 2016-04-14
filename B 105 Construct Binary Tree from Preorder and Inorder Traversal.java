//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//根据前序和中序构造二叉树 递归解法
//非递归解法：https://leetcode.com/discuss/84066/share-my-20-line-o-n-iterative-java-code-with-comments
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if(length == 0)
            return null;
        return buildSubTree(preorder, inorder, 0, length-1, 0, length-1);
    }
    
    public TreeNode buildSubTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if(preStart == preEnd)
            return root;
        int rootIndex = 0;
        for(int i=inStart; i<=inEnd; i++) {
            if(inorder[i] == preorder[preStart]) {
                rootIndex = i;
                break;
            }
        }
        /* 改成这样会快很多
        for(int i=istart, j=iend; i<=j; i++, j--) {
			if(inorder[i] == preorder[pstart]) {
				inorderIndex = i;
				break;
			}
			if(inorder[j] == preorder[pstart]) {
				inorderIndex = j;
				break;
			}
		}
        */
        root.left = buildSubTree(preorder, inorder, preStart+1, preStart+rootIndex-inStart, inStart, rootIndex-1);
        root.right = buildSubTree(preorder, inorder, preStart+rootIndex-inStart+1, preEnd, rootIndex+1, inEnd);
        return root;
    }
}
