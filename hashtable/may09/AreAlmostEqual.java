package hashtable.may09;

public class AreAlmostEqual {
    public boolean areAlmostEqual(String s1, String s2){
        int first = -1, second = -1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                if (first == -1){
                    first = i;
                } else if (second == -1){
                    second = i;
                } else {
                    return false;
                }
            }
        }

        //case 1 : already equal
        if (first == -1) return true;

        //Case 2 : exactly two mismatches
        return second != -1 &&
                s1.charAt(first) == s2.charAt(second) &&
                s1.charAt(second) == s2.charAt(first);
    }

    public static void main(String[] args) {
        AreAlmostEqual sol = new AreAlmostEqual();
        System.out.println(sol.areAlmostEqual("bank", "kanb")); // true
        System.out.println(sol.areAlmostEqual("attack", "defend")); // false
        System.out.println(sol.areAlmostEqual("kelb", "kelb")); // true
    }
}
