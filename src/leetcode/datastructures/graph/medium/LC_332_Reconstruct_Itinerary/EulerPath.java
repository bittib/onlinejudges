package leetcode.datastructures.graph.medium.LC_332_Reconstruct_Itinerary;
import java.util.*;

public class EulerPath {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> path = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] t : tickets) {
            map.computeIfAbsent(t[0], key -> new PriorityQueue<>()).add(t[1]);
        }
        dfs("JFK", map, path);
        return path;
    }

    void dfs(String from, Map<String, PriorityQueue<String>> map, LinkedList<String> path) {
        PriorityQueue<String> q = map.get(from);

        while (q != null && !q.isEmpty()) {
            dfs(q.poll(), map, path);
        }
        path.addFirst(from);
    }
}
