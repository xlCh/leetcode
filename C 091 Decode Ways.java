//https://leetcode.com/problems/decode-ways/
//计算数字组合成字母的方式个数 1~26分别对应a~z 注意考虑0的情况
//可以写成空间复杂度为O(1)的
//超短的代码：https://leetcode.com/discuss/94589/shortest-solution-in-c-using-dp
public int numDecodings(String s) {
        if(s.length() < 1 || s.charAt(0) == '0')
            return 0;
        if(s.length() == 1)
            return 1;
        int[] ways = new int[s.length()];
        ways[0] = 1;
        if((s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) <= '6')) && s.charAt(1) > '0')
            ways[1] = 2;
        else if(s.charAt(0) > '2' && s.charAt(1) == '0')
            return 0;
        else
            ways[1] = 1;
        for(int i=2; i<s.length(); i++) {
            if((s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= 6 + '0')) && s.charAt(i) > '0')
                ways[i] = ways[i-1] + ways[i-2];
            else if((s.charAt(i-1) > '2' || s.charAt(i-1) < '1') && s.charAt(i) == '0')
                return 0;
            else if((s.charAt(i-1) == '2' || s.charAt(i-1) == '1') && s.charAt(i) == '0')
                ways[i] = ways[i-2];
            else
                ways[i] = ways[i-1];
        }
        return ways[s.length()-1];
    }

//稍有不同 比起来还是太长 https://leetcode.com/discuss/91649/share-my-2ms-java-solution-with-o-1-spqce
public int numDecodings(String s) {
        if(s == null || s.isEmpty() || s.charAt(0) == '0')
            return 0;
        int prevprevways = 1;
        int prevways = 1;
        int ways = 1;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {
                if(i == 1) {
                    ways = prevways = (s.charAt(i) == '0') ? 1 : 2;
                    if(s.length() == 2)
                        return prevways;
                    continue;
                }
                else if(s.charAt(i) != '0') {
                    ways = prevprevways + prevways;
                }
                else {
                    ways = prevprevways;
                }
            }
            else if(s.charAt(i) == '0') {
                return 0;
            }
            else
                ways = prevways;
            prevprevways = prevways;
            prevways = ways;
        }
        return ways;
    }
