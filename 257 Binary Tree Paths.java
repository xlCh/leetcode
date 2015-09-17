//输出二叉树的所有路径
//递归写法

private List<String> treePaths = new ArrayList<String>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return new ArrayList<String>();
        getTreePath(root, "");
        return treePaths;
    }
    
    public void getTreePath(TreeNode root, String currentStr) {
        if(root.left == null && root.right == null) {
            treePaths.add(currentStr.concat(Integer.toString(root.val)));
        }
        if(root.left != null) {
            getTreePath(root.left, currentStr.concat(Integer.toString(root.val)).concat("->"));
        }
        if(root.right != null) {
            getTreePath(root.right, currentStr.concat(Integer.toString(root.val)).concat("->"));
        }
    }
