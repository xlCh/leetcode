//树的宽度优先遍历（Z形遍历）
//把普通BFS的队列变成栈即可 注意压栈顺序

public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root == null)
            return levels;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while(!stack1.empty() || !stack2.empty()) {
            List<Integer> layer1 = new ArrayList<Integer>();
            while(!stack1.empty()) {
                TreeNode temp = stack1.pop();
                if(temp.left != null)
                    stack2.push(temp.left);
                if(temp.right != null)
                    stack2.push(temp.right);
                layer1.add(temp.val);
            }
            if(layer1.size() > 0)
                levels.add(layer1);
            List<Integer> layer2 = new ArrayList<Integer>();
            while(!stack2.empty()) {
                TreeNode temp = stack2.pop();
                if(temp.right != null)
                    stack1.push(temp.right);
                if(temp.left != null)
                    stack1.push(temp.left);
                layer2.add(temp.val);
            }
            if(layer2.size() > 0)
                levels.add(layer2);
        }
        return levels;
    }
