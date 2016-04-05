//https://leetcode.com/problems/sum-root-to-leaf-numbers/
//所有路径上根到叶子值字符串的和
//    1
//   / \
//  2   3
//sum = 12 + 13 = 25

//BFS做法：
//1.另加一个queue: https://leetcode.com/discuss/70452/java-bfs-iterative-solution
//2.修改值: https://leetcode.com/discuss/76081/share-my-code-backtrack-and-bfs
//3.修改数据结构: https://leetcode.com/discuss/81418/very-simple-bfs-solution
int result = 0;
    
    public int sumNumbers(TreeNode root) {
        sum(root, 0);
        return result;
    }
    
    public void sum(TreeNode root, int already) {
        if(root == null) {
            return;
        }
        int val = already * 10 + root.val;
        if(root.left == null && root.right == null) {
            result += val;
            return;
        }
        sum(root.left, val);
        sum(root.right, val);
    }
