//https://leetcode.com/problems/h-index-ii/
//参考 https://leetcode.com/discuss/56170/java-binary-search-simple-and-clean
public int hIndex(int[] citations) {
        int len = citations.length;
        int low = 0, high = len - 1, medium;
        while(low <= high) {
            medium = (low + high) >>> 1;
            if(citations[medium] == len - medium)
                return citations[medium];
            else if(citations[medium] > len - medium)
                high = medium - 1;
            else
                low = medium + 1;
        }
        return len - low;
    }
