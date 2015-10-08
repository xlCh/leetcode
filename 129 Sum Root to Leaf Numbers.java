//所有路径上根到叶子值字符串的和
//    1
//   / \
//  2   3
//sum = 12 + 13 = 25

public int sumNumbers(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        subPathSum(root, "", paths);
        int count = 0;
        for(String path : paths) {
            count += Integer.parseInt(path);
        }
        return count;
    }
    
    public void subPathSum(TreeNode root, String sum, List<String> paths) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            paths.add(sum + root.val);
            return;
        }
        subPathSum(root.left, sum + root.val, paths);
        subPathSum(root.right, sum + root.val, paths);
    }
