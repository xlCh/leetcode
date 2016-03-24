//https://leetcode.com/problems/contains-duplicate-ii/
//判断距离k以内是否存在两个一样的元素
//更快的方法：双数组一同参与排序https://leetcode.com/discuss/89129/5ms-98-8%25-java-solution
//或者自造数据结构并实现Comparator接口，https://leetcode.com/discuss/88763/my-java-use-sort-beats-98-69%25-of-java-submissions
bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int, int> numMap;
        for(int i=0; i<nums.size(); i++) {
            unordered_map<int, int>::const_iterator found = numMap.find(nums.at(i));
            if(found == numMap.end()) {
                numMap[nums.at(i)] = i;
            }
            else if(i - numMap[nums.at(i)] <= k){
                return true;
            }
            else {
                numMap[nums.at(i)] = i;
            }
        }
        return false;
    }
