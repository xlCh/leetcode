//https://leetcode.com/problems/majority-element-ii/
//找出出现次数超过n/3的数字（可能为0 1 2个）
//借鉴Boyer-Moore Voting https://leetcode.com/discuss/69126/concise-java-solution-based-on-moores-voting-algorithm
public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums.length == 0)
            return res;
        int[] count = new int[2];
        int[] result = new int[2];
        for(int num : nums) {
            if(num == result[0])
                count[0]++;
            else if(num == result[1])
                count[1]++;
            else if(count[0] == 0) {
                result[0] = num;
                count[0]++;
            }
            else if(count[1] == 0) {
                result[1] = num;
                count[1]++;
            }
            else {
                count[0]--;
                count[1]--;
            }
        }
        count[0] = count[1] = 0;
        int numLen = nums.length / 3;
        for(int num : nums) {
            if(num == result[0])
                count[0]++;
            else if(num == result[1])
                count[1]++;
        }
        if(count[0] > numLen)
            res.add(result[0]);
        if(count[1] > numLen)
            res.add(result[1]);
        return res;
    }
