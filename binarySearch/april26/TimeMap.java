package binarySearch.april26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    static class Pair{
        String value;
        int timestamp;

        Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    private Map<String , List<Pair>>  map;

    public TimeMap(){
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp){
        map.computeIfAbsent(key, k-> new ArrayList<>()).add(new Pair(value,timestamp));
    }

    public String get(String key, int timestamp){
        if (!map.containsKey(key)){
            return "";
        }

        List<Pair> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String answer = "";

        while (left <= right){
            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp){
                answer = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;

    }



    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();

        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1)); // bar
        System.out.println(timeMap.get("foo", 3)); // bar
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4)); // bar2
        System.out.println(timeMap.get("foo", 5)); // bar2
    }
}
