//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//将有序数组转换为二叉搜索树
//递归解法

public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        return newBST(nums, 0, nums.length-1);
    }
    
    public TreeNode newBST(int[] nums, int low, int high) {
        if(low > high) {
            return null;
        }
        int middle = (low + high) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = newBST(nums, low, middle-1);
        root.right = newBST(nums, middle+1, high);
        return root;
    }
