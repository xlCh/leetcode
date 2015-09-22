//层次遍历 倒序（只在正序上稍作改动）

public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> levelStack = new Stack<List<Integer>>();
        if(root == null)
            return levelStack;
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
                levelStack.push(layer1);
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
                levelStack.push(layer2);
        }
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        while(!levelStack.isEmpty()) {
            levels.add(levelStack.pop());
        }
        return levels;
    }
