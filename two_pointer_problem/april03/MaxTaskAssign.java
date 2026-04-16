package two_pointer_problem.april03;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.TreeMap;

public class MaxTaskAssign {

    public int maxTaskAssign(int[] tasks, int[] workers,int pills,int strength){
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0, right = Math.min(tasks.length,workers.length);
        int ans = 0;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if (canAssign(tasks,workers,pills,strength,mid)){
                ans = mid;
                left = mid + 1;  //try more task
            }
            else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int k){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int m = workers.length;

        //take strongest k worker
        for (int i = m - k; i < m; i++) {
            map.put(workers[i],map.getOrDefault(workers[i],0) + 1);
        }

        //traverse tasks from hardest
        for (int i = k - 1; i >= 0 ; i--) {
            int task = tasks[i];

            //if strength worker can do without pill
            Integer worker = map.ceilingKey(task);
            if (worker != null){
                remove(map,worker);
            }
            //else try pill
            else {
                if (pills == 0) return false;

                //Find weakest worker who can do with poll
               Integer weakWorker = map.ceilingKey(task - strength);
               if (weakWorker == null) return false;
               remove(map,weakWorker);
               pills--;
            }
        }
        return true;
    }

    public  void remove (TreeMap<Integer,Integer> map, int key){
        if (map.get(key) == 1){
            map.remove(key);
        }
        else {
            map.put(key,map.get(key) - 1);
        }
    }

    public static void main(String[] args) {
        MaxTaskAssign sol = new MaxTaskAssign();

        int[] tasks = {3, 2, 1};
        int[] workers = {0, 3, 3};
        int pills = 1;
        int strength = 1;

        int result = sol.maxTaskAssign(tasks, workers, pills, strength);

        System.out.println("Maximum Tasks Assigned: " + result);
    }
}
