//储存水量的最大值

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
