package hashtable.may05;

public class MakeEqual {

    public boolean makeEqual(String[] words){
        int[] freq = new int[26];

        //step 1: count all char
        for (String word : words){
            for (char ch : word.toCharArray()){
                freq[ch - 'a']++;
            }
        }

        int n = words.length;

        //step 2 : check divisibility
        for (int count : freq){
            if (count % n != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MakeEqual sol = new MakeEqual();
        System.out.println(sol.makeEqual(new String[]{"abc","aabc","bc"})); // true
        System.out.println(sol.makeEqual(new String[]{"ab","a"})); // false
    }
}
