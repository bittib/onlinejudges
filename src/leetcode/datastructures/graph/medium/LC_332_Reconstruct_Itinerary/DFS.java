package leetcode.datastructures.graph.medium.LC_332_Reconstruct_Itinerary;
import java.util.*;

public class DFS {

    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> path = new LinkedList<>();
        Map<String, TreeMap<String, Integer>> map = new HashMap<>();
        for (String[] flight : tickets) {
            if (!map.containsKey(flight[0])) {
                map.put(flight[0], new TreeMap<>());
                map.get(flight[0]).put(flight[1], 1);
            } else {
                int count = map.get(flight[0]).containsKey(flight[1]) ? map.get(flight[0]).get(flight[1]) : 0;
                map.get(flight[0]).put(flight[1], count + 1);
            }
        }

        path.add("JFK");
        dfs("JFK", tickets.length + 1, map, path);
        return path;
    }

    boolean dfs(String from, int n, Map<String, TreeMap<String, Integer>> map, LinkedList<String> path) {
        if (path.size() == n) return true;

        if (map.containsKey(from)) {
            for (String to : map.get(from).keySet()) {
                int ind = map.get(from).get(to);
                if (ind > 0) {
                    map.get(from).put(to, ind - 1);
                    path.add(to);
                    if (dfs(to, n, map, path)) {
                        return true;
                    }
                    path.remove(path.size() - 1);
                    map.get(from).put(to, ind);
                }
            }
        }
        return false;
    }

}
