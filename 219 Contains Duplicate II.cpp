//判断距离k以内是否存在两个一样的元素
//使用unordered_map，一定还有其他的巧妙方法
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
