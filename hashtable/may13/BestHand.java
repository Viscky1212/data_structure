package hashtable.may13;

public class BestHand {

    public String bestHand(int[] ranks , char[] suits){
        //Step 1 : check flush
        boolean isFlush = true;

        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[0]){
                isFlush = false;
                break;
            }
        }

        if (isFlush){
            return "Flush";
        }

        //Step 2 : Count rank freq
        int[] freq = new int[14];
        for (int rank : ranks){
            freq[rank]++;
        }

        //Step 3 : check Three of a kind
        for (int count : freq){
            if (count >= 3){
                return "Three of Kind";
            }
        }

        //step 4 : check pair
        for (int count : freq){
            if (count >= 2){
                return "Pair";
            }
        }

        //Step 5 : otherwise High card
        return "High Card";
    }

    public static void main(String[] args) {
        BestHand sol = new BestHand();

        int[] ranks1  = {13,2,3,1,9};
        char[] suits1 = {'a','a','a','a','a'};
        System.out.println(sol.bestHand(ranks1, suits1));
        // Output: Flush

        int[] ranks2 = {4,4,2,4,4};
        char[] suits2 = {'d','a','a','b','c'};
        System.out.println(sol.bestHand(ranks2, suits2));
        // Output: Three of a Kind

        int[] ranks3 = {10,10,2,12,9};
        char[] suits3 = {'a','b','c','a','d'};
        System.out.println(sol.bestHand(ranks3, suits3));
        // Output: Pair
    }
}
