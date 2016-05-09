//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//寻找二叉搜索树中第k小的元素
//三种方法：https://leetcode.com/discuss/43771/implemented-java-binary-search-order-iterative-recursive
//          https://leetcode.com/discuss/68052/two-easiest-in-order-traverse-java
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        int count = countNodes(root.left);
        if(count >= k) {
            return kthSmallest(root.left, k);
        }
        else if(count == k - 1)
            return root.val;
        else {
            return kthSmallest(root.right, k-count-1);
        }
    }
    
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
