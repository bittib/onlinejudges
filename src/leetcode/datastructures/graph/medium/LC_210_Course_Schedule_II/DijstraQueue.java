package leetcode.datastructures.graph.medium.LC_210_Course_Schedule_II;
import java.util.*;

public class DijstraQueue {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] e : prerequisites) {
            indegree[e[0]]++;
            graph.computeIfAbsent(e[1], key -> new ArrayList<>()).add(e[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int x = 0; x < numCourses; x++) {
            if (indegree[x] == 0) {
                queue.offer(x);
            }
        }
        int i = 0;
        int[] path = new int[numCourses];
        while (!queue.isEmpty()) {
            int clazz = queue.poll();
            path[i++] = clazz;

            if (graph.containsKey(clazz)) {
                for (int dep : graph.get(clazz)) {
                    indegree[dep]--;
                    if (indegree[dep] == 0) {
                        queue.offer(dep);
                    }
                }
            }
        }
        return i == numCourses ? path : new int[]{};
    }

}
