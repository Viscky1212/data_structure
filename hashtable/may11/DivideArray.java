package hashtable.may11;

public class DivideArray {
// sol 7
    public boolean divideArray(int[] nums){
        int[] freq = new int[501];

        //count freq
        for (int num : nums){
            freq[num]++;
        }

        //check even freq
        for (int count : freq){
            if (count % 2 != 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        DivideArray sol = new DivideArray();
        int[] nums1 = {3,2,3,2,2,2};
        System.out.println(sol.divideArray(nums1));
        // true

        int[] nums2 = {1,2,3,4};
        System.out.println(sol.divideArray(nums2));
        // false
    }
}
