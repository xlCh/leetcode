//https://leetcode.com/problems/word-break/
//一段字符串是否能打散成词表中的词序列
//转化为图的BFS解法： https://leetcode.com/discuss/8479/a-solution-using-bfs
//DP解法
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] result = new boolean[s.length()+1];
        result[0] = true;
        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                if(result[j] && wordDict.contains(s.substring(j, i))) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }

//使用递归会在某个测试用例上超时：
public boolean wordBreak(String s, Set<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }
    
    public boolean wordBreak(String s, Set<String> wordDict, int start) {
        if(start == s.length())
            return true;
        for(int i=start+1; i<=s.length(); i++) {
            if(wordDict.contains(s.substring(start, i))) {
                if(wordBreak(s, wordDict, i+1))
                    return true;
            }
        }
        return false;
    }
