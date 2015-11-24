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
