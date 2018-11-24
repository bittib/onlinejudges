package leetcode.datastructures.graph.medium.LC_207_Course_Schedule;
import java.util.*;
public class BFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            graph.computeIfAbsent(pair[1], key -> new ArrayList<>()).add(pair[0]); // pay attention to the order here.
            indegree[pair[0]]++;
        }

        //store courses that have no prerequisites, in other words, the node with 0 indegree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int finishedCourses = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            finishedCourses++;
            if (graph.containsKey(node)) {
                for (int idx : graph.get(node)) {
                    indegree[idx]--;
                    if (indegree[idx] == 0) {
                        queue.offer(idx);
                    }
                }
            }
        }
        
        return finishedCourses == numCourses;
    }
    
    public static void main(String[] args) {

        t(2, new int[][]{{1, 0}}, true);
    }

    public static void t(int numCourses, int[][] prerequisites, boolean expectedResult) {
        boolean acturalResult = new BFS().canFinish(numCourses, prerequisites);
        System.out.printf("\nExpected %s, expected %s\n", acturalResult, expectedResult);
    }
}