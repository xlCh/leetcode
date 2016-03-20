//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
/*移除有序列表中的重复元素，返回最终长度
本代码运行时间过长，discuss中找到一个运行时间较短的，直接在原空间上进行替换，并删除最后几个元素

需要注意的是使用迭代器进行erase，会打断整个的链接，需要iter = XX.erase(iter)记录迭代器的下一个位置。
*/
int removeDuplicates(vector<int>& nums) {
        if(nums.empty())
            return 0;
        int length = 0;
        int temp = nums[0]-1;
        for(vector<int>::iterator iter=nums.begin();iter!=nums.end();)
        {
            if (temp != *iter) {
                temp = *iter;
                length++;
                ++iter;
            }
            else {
                iter = nums.erase(iter);
            }
        }
        return length;
    }
//Java 更短更快的方法：
public int removeDuplicates(int[] nums) {
        int low = 0, fast = 0;
        while(fast < nums.length) {
            if(nums[fast] == nums[low])
                fast++;
            else {
                nums[++low] = nums[fast];
            }
        }
        return low+1;
    }
