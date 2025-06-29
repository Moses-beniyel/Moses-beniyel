import java.util.Arrays;

public class NQuuen {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queen(board, 0));
        // System.out.println(Arrays.deepToString(board));
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        int row1 = row;
        while (row1 >= 0) {
            if (board[row1][col]) {
                return false;
            }
            row1--;

        }
        int row2 = row;
        int col2 = col;
        while (row2 >= 0 && col2 >= 0) {
            if (board[row2][col2]) {
                return false;
            }
            row2--;
            col2--;
        }
        int row3 = row;
        int col3 = col;
        while (row3 >= 0 && col3 < board.length) {
            if (board[row3][col3]) {
                return false;
            }
            col3++;
            row3--;
        }
        return true;
    }

    public static int queen(boolean board[][], int row) {

        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count+=queen(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;

    }

    public static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean ele : row) {
                if (ele) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.err.println();
        }
    }
}
