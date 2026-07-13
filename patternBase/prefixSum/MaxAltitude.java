package patternBase.prefixSum;

public class MaxAltitude {

    public int findMaxAltitude(int[] gain){
        int maxAltitude = 0;
        int currentAltitude = 0;

        for (int g : gain) {
            currentAltitude += g;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }
    public static void main(String[] args) {
        MaxAltitude maxAltitudeCalculator = new MaxAltitude();
        int[] gain = {-5, 1, 5, 0, -7};
        int maxAltitude = maxAltitudeCalculator.findMaxAltitude(gain);
        System.out.println("Maximum altitude: " + maxAltitude); // Output: 1
    }
}
