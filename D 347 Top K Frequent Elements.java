//https://leetcode.com/problems/top-k-frequent-elements/
//找出频率前k的数字
//可以用桶排序或堆
//用PriorityQueue实现堆：https://leetcode.com/discuss/101391/java-max-heap-and-min-heap-solutions
//自己实现的堆：https://leetcode.com/discuss/100644/java-solution-using-heap
//桶排序
public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
        for(int num : nums) {
            int element = 1;
            if(mapping.containsKey(num)) {
                element = mapping.get(num)+1;
            }
            mapping.put(num, element);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i=nums.length; i>=1; i--) {
            if(result.size() >= k)
                break;
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result;
    }
