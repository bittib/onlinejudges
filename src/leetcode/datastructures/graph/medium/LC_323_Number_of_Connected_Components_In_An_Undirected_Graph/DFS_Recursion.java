package leetcode.datastructures.graph.medium.LC_323_Number_of_Connected_Components_In_An_Undirected_Graph;

import java.util.ArrayList;
import java.util.List;

public class DFS_Recursion {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int totalComponents = 0;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                totalComponents++;
                dfs(adj, i, visited);
            }
        }
        return totalComponents;
    }

    void dfs(List<List<Integer>> adj, int current, boolean[] visited) {
        for (int i : adj.get(current)) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(adj, i, visited);
            }
        }
    }
}
