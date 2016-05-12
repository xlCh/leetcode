//https://leetcode.com/problems/word-ladder/
//从startword到endword 每次只修改一个字母 求路径（需要是词表中含有的单词）
//双端BFS https://leetcode.com/discuss/68935/two-end-bfs-in-java-31ms
//参考 https://leetcode.com/discuss/43940/another-accepted-java-solution-bfs
public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        q.offer(beginWord);
        q.offer(null);
        visited.add(beginWord);
        int level = 1;
        while(!q.isEmpty()) {
            String temp = q.poll();
            if(temp != null) {
                for(int i=0; i<temp.length(); i++) {
                    char[] chs = temp.toCharArray();
                    for(char j='a'; j<='z'; j++) {
                        chs[i] = j;
                        String word = new String(chs);
                        if(word.equals(endWord))
                            return level + 1;
                        else if(wordList.contains(word) && !visited.contains(word)) {
                            q.offer(word);
                            visited.add(word);
                        }
                    }
                }
            }
            else {
                level++;
                if(!q.isEmpty()) {
                    q.offer(null);//为了辨识BFS的层次
                }
            }
        }
        return 0;
    }
