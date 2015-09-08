//从n个版本中寻找第一个bad version
//二分搜索

int firstBadVersion(int n) {
        int start = 1, end = n;
        while(end-start>1) {
            int mid = start + (end-start)/2;
            if(isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        if(isBadVersion(start))
            return start;
        else
            return end;
    }

