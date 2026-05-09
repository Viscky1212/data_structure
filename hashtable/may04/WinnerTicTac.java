package hashtable.may04;

public class WinnerTicTac {

    public String tictactoe(int[][] moves){
        char[][] board = new char[3][3];

        //step 1 ; fill board
        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];

            board[r][c] = (i % 2 == 0) ? 'X' : 'O';
        }

        //step 2 : check winner
        if (win(board,'X')) return "A";
        if (win(board,'O')) return "B";

        //Step 3 : draw winner
        if (moves.length == 9) return "Draw";

        return "Pending";
    }

    private boolean win(char[][] b, char ch){
        //row
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == ch && b[i][1] == ch && b[i][2] == ch) {
                return true;
            }
        }

        //column
        for (int i = 0; i < 3; i++) {
            if (b[0][i] == ch && b[1][i] == ch && b[2][i] == ch) {
                return true;
            }
        }

        if (b[0][0] == ch && b[1][1] == ch && b[2][2] == ch) return true;
        if (b[0][2] == ch && b[1][1] == ch && b[2][0] == ch) return true;

        return false;
    }

    public static void main(String[] args) {

        WinnerTicTac sol = new WinnerTicTac();

        int[][] moves1 = {{0,0},{2,0},{1,1},{2,1},{2,2}};
        System.out.println(sol.tictactoe(moves1)); // A

        int[][] moves2 = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        System.out.println(sol.tictactoe(moves2)); // B

        int[][] moves3 = {
                {0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}
        };
        System.out.println(sol.tictactoe(moves3)); // Draw
    }
}
