package binarySearch.april27;

import java.util.*;

//Most importent for system design

public class TweetCounts {
    // tweetName -> sorted map of time -> count
    private Map<String, TreeMap<Integer, Integer>> tweetMap;

    public TweetCounts() {
        tweetMap = new HashMap<>();
    }

    // O(log N)
    public void recordTweet(String tweetName, int time) {
        tweetMap.putIfAbsent(tweetName, new TreeMap<>());

        TreeMap<Integer, Integer> timeMap = tweetMap.get(tweetName);
        timeMap.put(time, timeMap.getOrDefault(time, 0) + 1);
    }

    // O(K + log N)
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName,
                                                    int startTime, int endTime) {

        int interval = getInterval(freq);

        int buckets = ((endTime - startTime) / interval) + 1;

        List<Integer> result = new ArrayList<>(Collections.nCopies(buckets, 0));

        if (!tweetMap.containsKey(tweetName)) {
            return result;
        }

        TreeMap<Integer, Integer> timeMap = tweetMap.get(tweetName);

        // Get relevant timestamps only
        for (Map.Entry<Integer, Integer> entry :
                timeMap.subMap(startTime, true, endTime, true).entrySet()) {

            int time = entry.getKey();
            int count = entry.getValue();

            int index = (time - startTime) / interval;

            result.set(index, result.get(index) + count);
        }

        return result;
    }

    private int getInterval(String freq) {
        switch (freq) {
            case "minute": return 60;
            case "hour": return 3600;
            case "day": return 86400;
            default: throw new IllegalArgumentException("Invalid frequency");
        }
    }
    public static void main(String[] args) {
        TweetCounts tweetCounts = new TweetCounts();

        tweetCounts.recordTweet("tweet3", 0);
        tweetCounts.recordTweet("tweet3", 60);
        tweetCounts.recordTweet("tweet3", 10);

        System.out.println(
                tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59)
        ); // [2]

        System.out.println(
                tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60)
        ); // [2,1]

        tweetCounts.recordTweet("tweet3", 120);

        System.out.println(
                tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210)
        ); // [4]
    }
}
