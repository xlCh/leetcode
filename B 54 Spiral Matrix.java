//https://leetcode.com/problems/spiral-matrix/
//输出二维数组（m×n）转圈遍历后的顺序
//讨论区方法大同小异
public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0)
            return result;
        int start = 0, vend = matrix.length-1, hend = matrix[0].length-1;
        while(start < vend && start < hend) {
            for(int i=start; i<hend; i++)
                result.add(matrix[start][i]);
            for(int i=start; i<vend; i++)
                result.add(matrix[i][hend]);
            for(int i=hend; i>start; i--)
                result.add(matrix[vend][i]);
            for(int i=vend; i>start; i--)
                result.add(matrix[i][start]);
            start++;
            vend--;
            hend--;
        }
        if(start == vend) {
            for(int i=start; i<=hend; i++)
                result.add(matrix[start][i]);
        }
        else if(start == hend) {
            for(int i=start; i<=vend; i++)
                result.add(matrix[i][start]);
        }
        return result;
    }
