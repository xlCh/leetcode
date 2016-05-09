//https://leetcode.com/problems/largest-number/
//用数字组成最大的数（排序的一种）
//如果直接比较int的话 考虑的情况太多。。
public String largestNumber(int[] nums) {
        List<String> numStrs = new ArrayList<String>();
        for(int i=0; i<nums.length; i++) {
            numStrs.add("" + nums[i]);
        }
        Collections.sort(numStrs, (a, b)-> {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        });
        int i=0;
        while(i<nums.length && numStrs.get(i).equals("0"))
            i++;
        StringBuffer result = new StringBuffer();
        for(int j=i; j<numStrs.size(); j++) {
            result.append(numStrs.get(j));
        }
        return result.length() == 0?"0":result.toString();
    }

//使用优先队列
public String largestNumber(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(11,  
                new Comparator<Integer>() {  
                    public int compare(Integer i1, Integer i2) {  
                        String s1 = String.valueOf(i1) + i2;
                        String s2 = String.valueOf(i2) + i1;
                        return s2.compareTo(s1);
                    }  
                });
        for(int num : nums)
            queue.offer(num);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty() && queue.peek() == 0)
            queue.poll();
        while(!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        String result = sb.toString();
        return result.length() == 0 ? "0" : result;
    }
