/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        map.put(node, nodeCopy);
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode x = queue.poll();
            UndirectedGraphNode xCopy = map.get(x);
            
            for (UndirectedGraphNode child : x.neighbors) {
                if (!map.containsKey(child)) {
                    UndirectedGraphNode childCopy = new UndirectedGraphNode(child.label);
                    map.put(child, childCopy);
                    queue.offer(child);
                }
                xCopy.neighbors.add(map.get(child));
            }
        }
        
        return map.get(node);
    }
}