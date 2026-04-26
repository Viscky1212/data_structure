package binarySearch.april26;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SnapshotArray {

    private List<TreeMap<Integer,Integer>> map;
    private  int snapId;

    public SnapshotArray(int length){
        map = new ArrayList<>();
        snapId = 0;

        for (int i = 0; i < length; i++) {
            TreeMap<Integer,Integer> tm= new TreeMap<>();
            tm.put(0,0);
            map.add(tm);
        }
    }

    public void set(int index, int val){
        map.get(index).put(snapId,val);
    }

    public int snap(){
        return snapId++;
    }

    public int get(int index, int snap_id){
        TreeMap<Integer,Integer> tm = map.get(index);

        Integer key = tm.floorKey(snap_id);
        return tm.get(key);
    }

    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(3);

        snapshotArr.set(0, 5);
        int snapId0 = snapshotArr.snap();  // returns 0

        snapshotArr.set(0, 6);

        int value = snapshotArr.get(0, snapId0); // should return 5

        System.out.println("Snap ID: " + snapId0);
        System.out.println("Value at index 0, snap 0: " + value);
    }
}
