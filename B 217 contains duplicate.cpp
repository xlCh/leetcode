//https://leetcode.com/problems/contains-duplicate/
//判断是否存在相同元素
//注意unordered_set 可以存储无重复元素
//可以选择先排序再判断相邻两元素是否相同的方法
//更快的方法：找出最大值和最小值 新建一个尺寸为max-min+1的数组
bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> us;
        for(vector<int>::iterator it = nums.begin(); it != nums.end(); it++)
            us.insert(*it);
        return (nums.size() != us.size());
    }
