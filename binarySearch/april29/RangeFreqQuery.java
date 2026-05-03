package binarySearch.april29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class RangeFreqQuery {

//    List<Integer>[] ids = new ArrayList[10001];
//    Function<Integer,Integer> lower_bound = (pos) -> pos < 0 ? ~pos : pos;
//    public RangeFreqQuery(int[] arr){
//        for (int i = 0; i < ids.length; ++i) {
//            ids[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < arr.length; ++i) {
//            ids[arr[i]].add(i);
//        }
//    }
//    public int query(int l, int r, int v){
//        return lower_bound.apply(Collections.binarySearch(ids[v],r+1)) -
//                lower_bound.apply(Collections.binarySearch(ids[v],l));
//    }


    HashMap<Integer, List<Integer>> map;
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if(!map.containsKey(value)) return 0;
        List<Integer> list = map.get(value);
        int sz = list.size();

        int leftInd = preBinary(list, 0, sz-1, left);
        int rightInd = postBinary(list, 0, sz-1, right);

        return rightInd-leftInd;
    }
    public int preBinary(List<Integer> lst , int st, int ed, int tar){
        while(st <= ed){
            int mid = (st + ed) / 2;
            if(lst.get(mid) < tar){
                st = mid + 1;
            }
            else ed = mid - 1;
        }

        return st;
    }
    public int postBinary(List<Integer> lst , int st, int ed, int tar){
        while(st <= ed){
            int mid = (st + ed) / 2;
            if(lst.get(mid) <= tar){
                st = mid + 1;
            }
            else ed = mid - 1;
        }

        return st;
    }

    public static void main(String[] args) {
        // arr = [12, 10, 9, 5, 2, 12, 10, 9]
        int[] arr = {12, 10, 9, 5, 2, 12, 10, 9};
        RangeFreqQuery rfq = new RangeFreqQuery(arr);

        System.out.println(rfq.query(1, 6, 10)); // 2 (indices 1 and 6)
        System.out.println(rfq.query(0, 2, 9));  // 1 (index 2)
        System.out.println(rfq.query(0, 7, 12)); // 2 (indices 0 and 5)
        System.out.println(rfq.query(0, 7, 5));  // 1 (index 3)
        System.out.println(rfq.query(0, 7, 7));  // 0 (not present)
    }
}
