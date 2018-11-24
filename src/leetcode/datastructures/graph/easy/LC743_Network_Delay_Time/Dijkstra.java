package leetcode.datastructures.graph.easy.LC743_Network_Delay_Time;
/**
 * Dijkstra Algorithm - the shortest path
 * 
 * Let the node at which we are starting be called the initial node. 
 * Let the distance of node Y be the distance from the initial node to Y. 
 * Dijkstra's algorithm will assign some initial distance values and will try to improve them step by step:
 * 
 * 1. Mark all nodes unvisited. Create a set of all unvisited nodes called the unvisited set.
 * 2. Assign to every node a tentative distance value: set it to zero for our initial node and to infinity for all other nodes. Set the initial node as current.
 * 3. For the curent node, consider all of its unvisited neighbors and calculate their tentative distances through the current node. 
 *    Compare the newly calculated tentative distance and assign the smaller one. 
 * 4. When we are done considering all of the unvisited neighbors of the current node, mark the current node as visited and remove it from the unvisited set. 
 *    A visited node will never be checked again.
 * 5. If the destination node has been marked visited (when planning a route between two specific nodes) or if the smallest tentative distance among the nodes 
 *    in the unvisited set is infinity (when planning a complete traversal; occurs when there is no connection between the initial node and remaining unvisited nodes), then stop. The algorithm has finished.
 * 6. Otherwise, select the unvisited node that is marked with the smallest tentative distance, set it as the new "current node", and go back to step 3.
 */

import java.util.*;
public class Dijkstra {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Integer> dist = new HashMap<>();

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<int[]>()).add(new int[]{edge[1], edge[2]});
        }

        for (int node = 1; node <= N; node++) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(K, 0);
        boolean[] visited = new boolean[N+1];

        while (true) {
            int currentNode = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && dist.get(i) < minDistance) {
                    minDistance = dist.get(i);
                    currentNode = i;
                }
            }

            if (currentNode < 0) break;
            visited[currentNode] = true;
            if (graph.containsKey(currentNode)) {
                for (int[] neighbor : graph.get(currentNode)) {
                    dist.put(neighbor[0], Math.min(dist.get(neighbor[0]), minDistance + neighbor[1]));
                }
            }
        }
        int maxTime = 0;
        for (int time : dist.values()) {
            if (time == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }

    public int networkDelayTime2(int[][] times, int N, int K) {
        Map<Integer, Integer> delayTime = new HashMap<>();
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<int[]>()).add(new int[]{edge[1], edge[2]});
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[]{0, K});
        
        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            if (delayTime.containsKey(current[1])) continue;
                
            delayTime.put(current[1], current[0]);
            if (graph.containsKey(current[1])) {
                for(int[] neighbor : graph.get(current[1])) {
                    if (!delayTime.containsKey(neighbor[0])) {
                        heap.offer(new int[] {current[0] + neighbor[1], neighbor[0]});
                    }
                }
            }
        }
        
        if (delayTime.size() != N) {
            return -1;
        }
        
        int maxElapsedTime = 0;
        for (int arrivedTime : delayTime.values()) {
            maxElapsedTime = Math.max(maxElapsedTime, arrivedTime);
        }
        return maxElapsedTime;
    }
    
}