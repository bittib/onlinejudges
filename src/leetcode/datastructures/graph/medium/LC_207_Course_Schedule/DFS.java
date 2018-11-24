package leetcode.datastructures.graph.medium.LC_207_Course_Schedule;
import java.util.*;

public class DFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] pair : prerequisites) {
            graph.computeIfAbsent(pair[0], key -> new ArrayList<Integer>()).add(pair[1]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, i, visited)) {
                return false;
            }
        }
        return true;
    }

    boolean hasCycle(Map<Integer, List<Integer>> graph, int node, int[] visited) {
        if (visited[node] == 2) {
            return false;
        } 
        if (visited[node] == 1) {
            return true;
        }

        visited[node] = 1;
        
        if (graph.containsKey(node)) {
            for (int dep : graph.get(node)) {
                if (hasCycle(graph, dep, visited)) {
                    return true;
                }
            }
        }
        visited[node] = 2;
        return false;
    }
}