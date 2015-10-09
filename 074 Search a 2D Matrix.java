//查找矩阵 二分查找

public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length-1;
        int middle = (low + high) / 2;
        while(low < high - 1) {
            if(target < matrix[middle][0])
                high = middle;
            else if(target > matrix[middle][0])
                low = middle;
            else
                return true;
            middle = (low + high) / 2;
        }
        int row = -1;
        if(target > matrix[high][0])
            row = high;
        else if(target < matrix[high][0])
            row = low;
        else
            return true;
        low = 0;
        high = matrix[0].length - 1;
        middle = (low + high) / 2;
        while(low < high - 1) {
            if(target < matrix[row][middle])
                high = middle;
            else if(target > matrix[row][middle])
                low = middle;
            else
                return true;
            middle = (low + high) / 2;
        }
        if(target == matrix[row][low] || target == matrix[row][high])
            return true;
        else
            return false;
    }
