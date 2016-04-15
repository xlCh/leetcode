//https://leetcode.com/problems/binary-tree-right-side-view/
//从右边看二叉树，返回从上到下的List<Integer>
//递归解法 注意从右DFS https://leetcode.com/discuss/95672/java-recursion-solution-beats-89%25-easy-to-understand
//非递归解法 一个队列 https://leetcode.com/discuss/86391/sharing-solution-iterative-bfs-using-queue-documented-code
public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root);
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            while(!queue1.isEmpty()) {
                TreeNode temp = queue1.remove();
                if(queue1.isEmpty()) {
                    result.add(temp.val);
                }
                if(temp.left != null)
                    queue2.add(temp.left);
                if(temp.right != null)
                    queue2.add(temp.right);
            }
            while(!queue2.isEmpty()) {
                TreeNode temp = queue2.remove();
                if(queue2.isEmpty()) {
                    result.add(temp.val);
                }
                if(temp.left != null)
                    queue1.add(temp.left);
                if(temp.right != null)
                    queue1.add(temp.right);
            }
        }
        return result;
    }
