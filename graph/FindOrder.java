package graph;

import java.util.*;

public class FindOrder {

    public int[] findOrder(int numCourses, int[][] pre) {
        //Step 1: Build graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] p : pre) {
            int course = p[0];
            int prereq = p[1];

            adj.get(prereq).add(course);
            indegree[course]++;
        }

        //Step 2 : Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        //Step 3 : Process  BFS
        while (!queue.isEmpty()){
            int curr = queue.poll();
            result[index++] = curr;

            for (int neighbor : adj.get(curr)){
                indegree[neighbor]--;

                if (indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        //Step 4 : check cycle
        if (index != numCourses){
            return new int[0];  //cycle exists
        }
        return result;
    }
    public static void main(String[] args) {
        FindOrder sol = new FindOrder();
        int numCourses1 = 2;
        int[][] pre1 = {{1, 0}};

        int numCourses2 = 4;
        int[][] pre2 = {{1,0},{2,0},{3,1},{3,2}};

        System.out.println("Output 1: " + Arrays.toString(sol.findOrder(numCourses1, pre1)));
        System.out.println("Output 2: " + Arrays.toString(sol.findOrder(numCourses2, pre2)));

    }
}
