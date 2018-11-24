package leetcode.datastructures.graph.medium.LC_841_Keys_and_Rooms;

import java.util.*;
public class DfsStack {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        visited[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while ( !stack.isEmpty() ) {
            int current = stack.pop();
            for (int key : rooms.get(current)) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
