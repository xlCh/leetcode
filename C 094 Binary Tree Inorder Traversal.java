//https://leetcode.com/problems/binary-tree-inorder-traversal/
//二叉树的中序遍历 递归解法

public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traverse = new ArrayList<Integer>();
        inorder(root, traverse);
        return traverse;
    }
    
    public void inorder(TreeNode root, List<Integer> traverse) {
        if(root == null)
            return;
        inorder(root.left, traverse);
        traverse.add(root.val);
        inorder(root.right, traverse);
    }

//非递归写法
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode cur = root;
    	while(!stack.isEmpty() || cur != null) {
    		if(cur != null) {
    			stack.push(cur);
    			cur = cur.left;
    		}
    		else {
    			TreeNode temp = stack.pop();
    			result.add(temp.val);
    			cur = temp.right;
    		}
    	}
    	return result;
    }
