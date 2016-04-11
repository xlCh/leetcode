//https://leetcode.com/problems/search-a-2d-matrix-ii/
//在矩阵中搜索，从左到右、从上到下都是递增顺序
//写的太复杂了 有简单方法：https://leetcode.com/discuss/94145/clean-easy-solution-in-java

public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1, n = matrix[0].length - 1;
        int sLow = 0, sHigh = m, sMedium = sHigh >>> 1;
        int eLow = 0, eHigh = m, eMedium = eHigh >>> 1;
        int start, end;
        while(sLow < sHigh - 1) {
        	if(matrix[sMedium][0] == target)
        		return true;
        	else if(matrix[sMedium][0] < target)
        		sLow = sMedium;
        	else
        		sHigh = sMedium - 1;
        	sMedium = (sLow + sHigh) >>> 1;
        }
        end = matrix[sHigh][0] <= target ? sHigh : sLow;
        while(eLow < eHigh) {
        	if(matrix[eMedium][n] == target)
        		return true;
        	else if(matrix[eMedium][n] < target)
        		eLow = eMedium + 1;
        	else
        		eHigh = eMedium;
        	eMedium = (eLow + eHigh) >>> 1;
        }
        start = eLow;
        for(int i=start; i<=end; i++) {
        	if(search(matrix[i], target))
        		return true;
        }
        return false;
    }
	
    public boolean search(int[] nums, int target) {
    	int low = 0, high = nums.length - 1;
    	int medium = (low + high) >>> 1;
    	while(low < high) {
    		if(nums[medium] == target)
    			return true;
    		else if(nums[medium] < target)
    			low = medium + 1;
    		else
    			high = medium - 1;
    		medium = (low + high) >>> 1;
    	}
    	return nums[low] == target;
    }
