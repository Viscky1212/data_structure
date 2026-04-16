package two_pointer_problem;

public class PushDominoes {

    public static String pushDominoes(String dominoes){
        String d = "L" + dominoes + "R";

        StringBuilder res = new StringBuilder();

        int i = 0;

        for (int j = 1; j < d.length(); j++) {
            if (d.charAt(j) == '.') {
                continue;
            }

            int middle = j - i - 1;

            if (i > 0){
                res.append(d.charAt(i));
            }

            if (d.charAt(i) == d.charAt(j)){
                for (int k = 0; k < middle; k++) {
                    res.append(d.charAt(i));
                }
            } else if (d.charAt(i) == 'L' && d.charAt(j) == 'R'){
                for (int k = 0; k < middle; k++) {
                    res.append('.');
                }
            } else {
                for (int k = 0; k < middle / 2; k++) {
                    res.append('R');
                }
                if (middle % 2 == 1){
                    res.append('.');
                }

                for (int k = 0; k < middle / 2 ; k++) {
                    res.append('L');
                }
            }
            i = j;

        }
        return res.toString();
    }

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";

        String result = pushDominoes(dominoes);

        System.out.println("Final Domino State: " + result);
    }
}
