//https://leetcode.com/problems/triangle/
//三角从上到下和的最小值 注意是对称的三角

public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] minSums = new int[rows];
        minSums[0] = triangle.get(0).get(0);
        for(int i=1; i<rows; i++) {
            List<Integer> row = triangle.get(i);
            for(int j=i; j>=0; j--) {
                if(j == 0)
                    minSums[j] += row.get(j);
                else if(j == i)
                    minSums[j] = minSums[j-1] + row.get(j);
                else 
                    minSums[j] = Math.min(minSums[j], minSums[j-1]) + row.get(j);
            }
            
        }
        int min = minSums[0];
        for(int i=0; i<rows; i++) {
            min = Math.min(minSums[i], min);
        }
        return min;
    }
