package binarySearch.april26;

import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {

    private int[] times;
    private int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times){
        this.times = times;
        this.leaders = new int[persons.length];

        Map<Integer,Integer> voteCount = new HashMap<>();
        int currentLeader = -1;
        int maxVote = 0;

        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];
            int votes = voteCount.getOrDefault(person, 0) + 1;
            voteCount.put(person,votes);

            if (votes >= maxVote){
                currentLeader = person;
                maxVote = votes;
            }
            leaders[i] = currentLeader;
        }
    }

    public int q(int t){
        int left = 0;
        int right = times.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (times[mid] <= t){
                left = mid + 1;
            } else {
               right = mid - 1;
            }
        }
        return leaders[right];
    }

    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};

        TopVotedCandidate obj = new TopVotedCandidate(persons, times);

        System.out.println(obj.q(3));   // 0
        System.out.println(obj.q(12));  // 1
        System.out.println(obj.q(25));  // 1
        System.out.println(obj.q(15));  // 0
        System.out.println(obj.q(24));  // 0
        System.out.println(obj.q(8));   // 1
    }
}
