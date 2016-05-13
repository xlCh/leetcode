//https://leetcode.com/problems/palindrome-partitioning/
//非递归 https://leetcode.com/discuss/9623/my-java-dp-only-solution-without-recursion-o-n-2
//注意如果先substring再判断回文会超时，应该先判断再substring
//可以把string转化为char[]
List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        partition(s, 0, new ArrayList<String>());
        return result;
    }
    
    public void partition(String s, int start, List<String> already) {
        if(start == s.length()) {
            result.add(new ArrayList<String>(already));
            return;
        }
        for(int i=start+1; i<=s.length(); i++) {
            if(s.charAt(i-1) == s.charAt(start)) {
                String temp = s.substring(start, i);
                if(isPalindrome(temp)) {
                    already.add(temp);
                    partition(s, i, already);
                    already.remove(already.size()-1);
                }
            }
        }
    }
    
    public boolean isPalindrome(String temp) {
        for(int i=0, j=temp.length()-1; i<j; i++, j--) {
            if(temp.charAt(i) != temp.charAt(j))
                return false;
        }
        return true;
    }
