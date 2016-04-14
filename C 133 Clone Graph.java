//https://leetcode.com/problems/clone-graph/
//复制图
//深度优先遍历 递归解法
//非递归解法 BFS：https://leetcode.com/discuss/80503/java-bfs-with-comments
public class Solution {
    
    private Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        if(mapping.containsKey(node))
            return mapping.get(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        mapping.put(node, copy);
        for(UndirectedGraphNode neigh : node.neighbors) {
            copy.neighbors.add(cloneGraph(neigh));
        }
        return copy;
    }
}
