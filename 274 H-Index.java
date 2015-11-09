//计算h-index https://en.wikipedia.org/wiki/H-index、
//另一种方法不排序 占用额外空间

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
