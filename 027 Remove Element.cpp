//移除值为val的元素，并返回移除后vector的size
int removeElement(vector<int>& nums, int val) {
        int valNum = 0;
        for(int i=0, j=0; i<nums.size(); i++) {
            if(nums[i] == val) {
                valNum++;
            }
            else if(j+valNum < nums.size())
                nums[j] = nums[(j++)+valNum];
        }
        return nums.size() - valNum;
    }
