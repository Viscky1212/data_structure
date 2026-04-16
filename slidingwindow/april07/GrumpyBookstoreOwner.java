package slidingwindow.april07;

public class GrumpyBookstoreOwner {

  public  static int maxSatisfied(int[] customers, int[] grumpy, int minutes){
      int n = customers.length;
      int baseSatisfied = 0;

      //Step 1 : Already satisfied with customer
      for (int i = 0; i < n; i++) {
          if (grumpy[i] == 0){
              baseSatisfied += customers[i];
          }
      }
      // Step 2 : Sliding window to find max extra customers
      int extra = 0;
      int maxExtra = 0;

      for (int i = 0; i < n; i++) {
          //Add current if grumpy
          if (grumpy[i] == 1){
              extra += customers[i];
          }

          //Maintain window size
          if (i >= minutes && grumpy[i - minutes] == 1){
              extra -= customers[ i - minutes];
          }
          //track max
          maxExtra = Math.max(maxExtra, extra);
      }
      return baseSatisfied + maxExtra;
  }


    public static void main(String[] args) {

        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy =   {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;

        int result = maxSatisfied(customers, grumpy, minutes);

        System.out.println("Maximum satisfied customers: " + result);
    }
}
