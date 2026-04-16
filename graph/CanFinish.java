package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinish {

    public boolean canFinish(int numCourse, int[][] prerequisite){
        //Build graph
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourse; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourse];

        for (int[] pre : prerequisite){
            int course = pre[0];
            int prereq = pre[1];

            adj.get(prereq).add(course);
            indegree[course]++;
        }

        //Step 2 : Add nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourse; i++) {
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }
        int completed = 0;

        //Step 3 : Process queue
        while (!queue.isEmpty()){
            int curr = queue.poll();
            completed++;

            for (int neighbor : adj.get(curr)){
                indegree[neighbor]--;
                if (indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        //Step 4 : Check if all courses completed
        return completed == numCourse;
    }

    public static void main(String[] args) {

        CanFinish sol = new CanFinish();
        int numCourses1 = 2;
        int[][] pre1 = {{1, 0}};

        int numCourses2 = 2;
        int[][] pre2 = {{1, 0}, {0, 1}};

        System.out.println("Output 1: " + sol.canFinish(numCourses1, pre1)); // true
        System.out.println("Output 2: " + sol.canFinish(numCourses2, pre2)); // false
    }
}
