package patternBase.prefixSum.hard;

public class MinKBitFlips {

//    public static int minKBitFlips(int[] nums, int k) {
//        int n = nums.length;
//        int flips = 0;
//        int flipCount = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (i >= k) {
//                flipCount ^= nums[i - k];
//            }
//            if (nums[i] == flipCount) {
//                if (i + k > n) {
//                    return -1;
//                }
//                flips++;
//                flipCount ^= 1;
//            }
//        }
//
//        return flips;
//    }


    public  static int minKBitFlips(int[] nums, int k) {

        int n = nums.length;

        int[] diff = new int[n];

        int flipCount = 0;

        int answer = 0;

        for(int i=0;i<n;i++){

            // यदि k दूरी पहले कोई flip शुरू हुई थी,
            // उसका प्रभाव अब समाप्त हो गया।
            if(i>=k){

                flipCount-=diff[i-k];
            }

            // यदि current value 0 है
            // (flipCount के बाद भी)
            if(flipCount%2==nums[i]){

                // Flip करना संभव नहीं
                if(i+k>n){

                    return -1;
                }

                answer++;

                flipCount++;

                diff[i]=1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        int k = 1;
        int result = minKBitFlips(nums, k);
        System.out.println("Minimum number of K-bit flips: " + result);
    }
}
