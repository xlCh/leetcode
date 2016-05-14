//https://leetcode.com/problems/contains-duplicate-iii/
//使用二叉搜索树（TreeSet）注意可能溢出的情况 https://leetcode.com/discuss/38177/java-o-n-lg-k-solution
//桶排序 注意long的转换位置 参考https://leetcode.com/discuss/38206/ac-o-n-solution-in-java-using-buckets-with-explanation
public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0)
            return false;
        Map<Long, Long> mapping = new HashMap<Long, Long>(k);
        for(int i=0; i<nums.length; i++) {
            long reNum = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = reNum / ((long)t + 1);
            if(mapping.containsKey(bucket) 
                || (mapping.containsKey(bucket-1) && reNum-mapping.get(bucket-1) <= t)
                || (mapping.containsKey(bucket+1) && mapping.get(bucket+1)-reNum <= t))
                return true;
            if(mapping.size() == k) {
                long lastBucket = ((long)nums[i-k]-Integer.MIN_VALUE) / ((long)t + 1);
                mapping.remove(lastBucket);
            }
            mapping.put(bucket, reNum);
        }
        return false;
    }
