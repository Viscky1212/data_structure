package two_pointer_problem;

public class CaptureFortsApp {

    public int captureForts(int[] forts){
        int max = 0;
        int last = -1;  // last non-zero index

        for (int i = 0; i < forts.length; i++) {

            if (forts[i] != 0){
                if (last != -1 && forts[i] != forts[last]){
                    //valid pair
                    max = Math.max(max, i - last - 1);
                }
                last = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        CaptureFortsApp solution = new CaptureFortsApp();

        int[] forts1 = {1,0,0,-1,0,0,0,0,1};
        int[] forts2 = {0,0,1,-1};

        System.out.println(solution.captureForts(forts1)); // 4
        System.out.println(solution.captureForts(forts2)); // 0
    }
}
