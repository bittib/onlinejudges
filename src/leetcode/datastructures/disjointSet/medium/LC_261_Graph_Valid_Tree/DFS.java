package leetcode.datastructures.disjointSet.medium.LC_261_Graph_Valid_Tree;
/**
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0,1] is the same as [1,0] and thus will not appear together in edges.
 */
import java.util.*;
public class DFS {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> vertex = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            vertex.add(new ArrayList<>());
        }

        
        for (int[] edge : edges) {
            vertex.get(edge[0]).add(edge[1]);
            vertex.get(edge[1]).add(edge[0]);
        }
        if (hasCycle(0, -1, vertex, visited)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    boolean hasCycle(int v, int parent, ArrayList<ArrayList<Integer>> vertex, boolean[] visited) {
        if (visited[v]) {
            return true;
        }
        visited[v] = true;
        for (int u : vertex.get(v)) {

            if (u != parent && hasCycle(u, v, vertex, visited)) {
                return true;
            }
        }
        return false;
    }
}