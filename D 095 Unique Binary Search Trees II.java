//https://leetcode.com/problems/unique-binary-search-trees-ii/
//另一种做法：https://leetcode.com/discuss/9790/java-solution-with-dp
//另一种快的 https://leetcode.com/discuss/81728/java-2ms-solution-beats-92%25
//不重复的二叉搜索树 n个元素 利用中序特征
public List<TreeNode> generateTrees(int n) {
        if(n < 1)
            return new ArrayList<TreeNode>();
        else
            return generate(1, n);
    }
	
	public List<TreeNode> generate(int start, int end) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(start > end) {
			result.add(null);
			return result;
		}
		for(int i=start; i<=end; i++) {
			List<TreeNode> left = generate(start, i-1);
			List<TreeNode> right = generate(i+1, end);
			for(TreeNode l : left) {
				for(TreeNode r : right) {
					TreeNode newNode = new TreeNode(i);
					newNode.left = l;
					newNode.right = r;
					result.add(newNode);
				}
			}
		}
		return result;
	}
