package leetcode.datastructures.graph.easy.LC743_Network_Delay_Time;

import java.util.*;
public class DFS {

    /**
     * There are N network nodes, labelled 1 to N.

     * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, 
     * and w is the time it takes for a signal to travel from source to target.
     * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
     * Note:
     *  N will be in the range [1, 100].
     *  K will be in the range [1, N].
     *  The length of times will be in the range [1, 6000].
     *  All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
     * 
     * 
     * DFS solution
     * 
     * Time Complexity: O(N^N + easy) where easy is the number of edges (stored in times).
     * Space Complexity: O(N + easy)
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Integer> delayTime = new HashMap<>();
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            delayTime.put(i, Integer.MAX_VALUE);
        }
        
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<int[]>()).add(new int[]{edge[1], edge[2]});
        }

        dfs(graph, delayTime, K, 0);
        
        int maxElapsedTime = 0;
        for (int arrivedTime : delayTime.values()) {
            if (arrivedTime == Integer.MAX_VALUE) {
                return -1;
            }
            maxElapsedTime = Math.max(maxElapsedTime, arrivedTime);
        }
        return maxElapsedTime;
    }
    
    void dfs(Map<Integer, List<int[]>> graph, Map<Integer, Integer> delayTime, int vertex, int arrivedTime) {
        if (arrivedTime >= delayTime.get(vertex)) {
            return;
        }
        delayTime.put(vertex, arrivedTime);
        if (graph.containsKey(vertex)) {
            for (int[] neighbor : graph.get(vertex)) {
                dfs(graph, delayTime, neighbor[0], arrivedTime + neighbor[1]);
            }
        }
    }
}