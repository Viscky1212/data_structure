package hashtable.may09;

import java.util.ArrayList;
import java.util.List;
//problem 4

public class OrderedStream {

    private String[] stream;
    private int ptr;

    public OrderedStream(int n){
        stream = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value){
        stream[idKey] = value;

        List<String> result = new ArrayList<>();

        //collect chunk
        while (ptr < stream.length && stream[ptr] != null){
            result.add(stream[ptr]);
            ptr++;
        }
        return result;
    }

    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);

        System.out.println(os.insert(3, "ccccc")); // []
        System.out.println(os.insert(1, "aaaaa")); // ["aaaaa"]
        System.out.println(os.insert(2, "bbbbb")); // ["bbbbb","ccccc"]
        System.out.println(os.insert(5, "eeeee")); // []
        System.out.println(os.insert(4, "ddddd")); // ["ddddd","eeeee"]
    }
}
