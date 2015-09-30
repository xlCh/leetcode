//返回所有和为sum的路径 递归解法

public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        subPathSum(root, sum, path, paths);
        return paths;
    }
    
    public void subPathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> paths) {
        if(root == null)
            return;
        List<Integer> newPath = new ArrayList<>(path);//注意 直接使用path会导致超时
        newPath.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            paths.add(newPath);
            return;
        }
        subPathSum(root.left, sum-root.val, newPath, paths);
        subPathSum(root.right, sum-root.val, newPath, paths);
    }
