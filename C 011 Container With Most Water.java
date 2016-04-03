//https://leetcode.com/problems/container-with-most-water/
//储存水量的最大值（注意是到x轴）
//优化（不可能的值不需要计算）：https://leetcode.com/discuss/78437/java-3ms-solution-with-step-by-step-explanations-beats-85%25

public int maxArea(int[] height) {
        int result = 0;
        int low = 0, high = height.length-1;
        while(low < high) {
            result = Math.max(result, Math.min(height[high], height[low]) * (high-low));
            if(height[low] < height[high])
                low++;
            else
                high--;
        }
        return result;
    }
