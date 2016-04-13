//https://leetcode.com/problems/path-sum-ii
//返回所有和为sum的路径 递归解法
//非递归解法：https://leetcode.com/discuss/86916/sharing-my-16ms-c-non-recursive-solution
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

//略有不同
List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        sum(root, new ArrayList<Integer>(), sum);
        return result;
    }
    
    public void sum(TreeNode root, List<Integer> already, int remain) {
        if(root == null)
            return;
        if(remain == root.val && root.left == null && root.right == null) {
            List<Integer> res = new ArrayList<Integer>(already);
            res.add(root.val);
            result.add(res);
            return;
        }
        already.add(root.val);
        sum(root.left, already, remain-root.val);
        sum(root.right, already, remain-root.val);
        already.remove(already.size()-1);
    }
