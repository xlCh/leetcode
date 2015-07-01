//输出一串数字的范围，例如给出[0,1,2,4,5,7]，返回["0->2","4->5","7"]

vector<string> summaryRanges(vector<int>& nums) {
        int i = 0;
        vector<string> rangeV;
        while(i<nums.size()) {
            int start = i;
            stringstream s;
            while(i != nums.size()-1 && nums[i+1] == nums[i]+1)
                i++;
            if(i-start == 0)
                s << nums[i++];
            else
                s << nums[start] << "->" << nums[i++];
            rangeV.push_back(s.str());
        }
        return rangeV;
    }
