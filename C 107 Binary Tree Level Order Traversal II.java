//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
//层次遍历 倒序（只在正序上稍作改动）
//可正序后再Collections.reverse（递归解法快一些） 更快的是BFS：https://leetcode.com/discuss/81189/java-1ms-beats-98%25-using-preorder
public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null)
            return result;
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root);
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> layer1 = new ArrayList<Integer>();
            while(!queue1.isEmpty()) {
                TreeNode temp = queue1.remove();
                if(temp.left != null)
                    queue2.add(temp.left);
                if(temp.right != null)
                    queue2.add(temp.right);
                layer1.add(temp.val);
            }
            if(layer1.size() > 0)
                result.add(0, layer1);
            List<Integer> layer2 = new ArrayList<Integer>();
            while(!queue2.isEmpty()) {
                TreeNode temp = queue2.remove();
                if(temp.left != null)
                    queue1.add(temp.left);
                if(temp.right != null)
                    queue1.add(temp.right);
                layer2.add(temp.val);
            }
            if(layer2.size() > 0)
                result.add(0, layer2);
        }
        return result;
    }
