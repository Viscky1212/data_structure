package hash_hashing.practice;

public class CanConstruct {

    public static boolean canConstruct(String ransomeNote, String magazine){
        int[] freq = new int[26];

        for (char ch : magazine.toCharArray()){
            freq[ch - 'a']++;
        }

        //step 2 : try to construct ransomeNote
        for(char ch : ransomeNote.toCharArray()){
            //if character not found
            if(freq[ch - 'a'] == 0){
                return  false;
            }
            freq[ch - 'a']--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canConstruct("a","b"));
        System.out.println(canConstruct("aa","ab"));
        System.out.println(canConstruct("aa","aab"));
    }
}
