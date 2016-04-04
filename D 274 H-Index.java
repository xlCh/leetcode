//https://leetcode.com/problems/h-index/
//计算h-index https://en.wikipedia.org/wiki/H-index
//另一种方法不排序 占用额外空间，转化思想https://leetcode.com/discuss/93819/java-bucket-sort-o-n-solution-with-detail-explanation
//还有一种方法 更简单https://leetcode.com/discuss/79740/according-to-the-definition-of-h-index-in-wiki-it-is-simple
public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        if(length < 1)
            return 0;
        int h = Math.min(citations[length-1], citations.length);
        while(h > 0) {
            if(citations[length-h] >= h && (length-h == 0 || citations[length-h-1] <= h))
                return h;
            h--;
        }
        return 0;
    }
