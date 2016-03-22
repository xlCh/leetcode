//https://leetcode.com/problems/first-bad-version
//从n个版本中寻找第一个bad version
//二分搜索

    public int firstBadVersion(int n) {
        int low = 1, high = n, medium = low + (high - low) / 2;
        while(low < high) {
            if(isBadVersion(medium)) {
                high = medium;
            }
            else {
                low = medium + 1;
            }
            medium = low + (high - low) / 2;
        }
        return medium;
    }

