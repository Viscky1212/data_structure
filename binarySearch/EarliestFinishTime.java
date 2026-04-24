package binarySearch;

public class EarliestFinishTime {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration){
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                int finishLandFirst = Math.max(landStartTime[i] + landDuration[i], waterStartTime[j]) + waterDuration[j];
                int finishWaterFirst = Math.max(waterStartTime[j] + waterDuration[j], landStartTime[i]) + landDuration[i];

                ans = Math.min(ans, Math.min(finishLandFirst,finishWaterFirst));

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EarliestFinishTime solution = new EarliestFinishTime();
        int[] landStartTime1 = {2, 8};
        int[] landDuration1 = {4, 1};
        int[] waterStartTime1 = {6};
        int[] waterDuration1 = {3};

        System.out.println(solution.earliestFinishTime(
                landStartTime1, landDuration1, waterStartTime1, waterDuration1)); // 9

        int[] landStartTime2 = {5};
        int[] landDuration2 = {3};
        int[] waterStartTime2 = {1};
        int[] waterDuration2 = {10};

        System.out.println(solution.earliestFinishTime(
                landStartTime2, landDuration2, waterStartTime2, waterDuration2)); // 14
    }
}
