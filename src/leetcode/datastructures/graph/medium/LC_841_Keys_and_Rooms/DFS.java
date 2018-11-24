package leetcode.datastructures.graph.medium.LC_841_Keys_and_Rooms;

import java.util.*;
public class DFS {

    // Time Complexity: O(N + E)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        if (n == 1) {
            return true;
        }
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        return visited.size() == n;
    }

    void dfs(List<List<Integer>> rooms, int current, Set<Integer> visited) {
        visited.add(current);
        for (int key : rooms.get(current)) {
            if( !visited.contains(key) ) {
                dfs(rooms, key, visited);
            }
        }
    }
}
