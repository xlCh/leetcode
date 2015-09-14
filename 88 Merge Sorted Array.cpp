//合并两个有序列表（无重复元素）

void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int end = m+n-1;
        m--;
        n--;
        while(m >= 0 && n >= 0) {
            nums1.at(end--) = (nums1.at(m)>nums2.at(n)?nums1.at(m--):nums2.at(n--));
        }
        while(n >= 0) {
            nums1.at(end--) = nums2.at(n--);
        }
    }
