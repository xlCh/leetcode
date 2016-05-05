//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//最长无重复字母子串的长度
//若直接分配int[256] 则O(n)space可以变为O(1)

public int lengthOfLongestSubstring(String s) {
        Set<Character> already = new HashSet<Character>();
        int low = 0, high = 0, longest = 0;
        while(high < s.length()) {
            while(high < s.length() && already.add(s.charAt(high))) {
                high++;
            }
            already.remove(s.charAt(low++));
            longest = Math.max(longest, high-low+1);
        }
        return longest;
    }

//O(1) space
public int lengthOfLongestSubstring(String s) {
        int len = 0;
    	int slow = 0, fast = 0;
    	int[] existed = new int[256];
    	for(int i=0; i<256; i++)
    		existed[i] = -1;
    	while(fast < s.length()) {
    		if(existed[s.charAt(fast)] >= slow) {
    			if(len < fast - slow)
    				len = fast - slow;
    			slow = existed[s.charAt(fast)]+1;
    		}
    		existed[s.charAt(fast)] = fast;
    		fast++;
    	}
    	return fast-slow>len ? fast-slow : len;
    }
