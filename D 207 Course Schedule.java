//https://leetcode.com/problems/course-schedule/
//BFS是计算出入度平衡；问题中的DFS效率低，可参考评论：https://leetcode.com/discuss/39456/java-dfs-and-bfs-solution

public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<Integer>());
        for(int i=0; i<prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            if(!dfs(graph, visited, i))
                return false;
        }
        return true;
    }
    
    public boolean dfs(List<List<Integer>> graph, int[] visited, int i) {
        visited[i] = 1;
        for(int num : graph.get(i)) {
            if(visited[num] == 1 || (visited[num] == 0 && !dfs(graph, visited, num)))
                return false;
        }
        visited[i] = 2;
        return true;
    }
