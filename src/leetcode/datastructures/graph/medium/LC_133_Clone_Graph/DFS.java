package leetcode.datastructures.graph.medium.LC_133_Clone_Graph;
import java.util.*;
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class DFS {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return cloneGraph(node, map);
    }
    
    UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
        map.put(node, clonedNode);
        for (UndirectedGraphNode child : node.neighbors) {
            UndirectedGraphNode clonedChild = null;
            if (!map.containsKey(child)) {
                clonedChild = cloneGraph(child, map);
            } else {
                clonedChild = map.get(child);
            }
            clonedNode.neighbors.add(clonedChild);
        }
        return clonedNode;
    }
}