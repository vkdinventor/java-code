package backtracking;

import java.util.ArrayList;

public class NQueenProblem {

    public static void main(String[] args) {
        new NQueenProblem().solveNQueens(8);
    }

    public ArrayList<ArrayList<String>> solveNQueens(int a) {

        boolean[][] board = new boolean[a][a];
        ArrayList<ArrayList<String>> ansList = new ArrayList<ArrayList<String>>();
        solveNQueensR(ansList, board, 0, a);
        return ansList;
    }

    boolean solveNQueensR(ArrayList<ArrayList<String>> ansList, boolean[][] board, int row, int n) {

        if (n == row) {
            ArrayList<String> ans = new ArrayList<>();
            ArrayList<String> ansRev = new ArrayList<>();
            StringBuilder sb;
            for(int i = 0; i < board.length; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j]) {
                        sb.append("Q");
                        System.out.print("Q ");
                    } else {
                        sb.append(".");
                        System.out.print("- ");
                    }
                }
                ans.add(sb.toString());
                ansRev.add(sb.reverse().toString());
                System.out.println();
            }
            ansList.add(ans);
            if(!ans.equals(ansRev)){
                ansList.add(ansRev);
            }
            // return false to explore all possibility
            return true;
        }

        for (int j = 0; j < board.length; j++) {
            if (canPlace(row, j, board)) {
                board[row][j] = true;
                if (solveNQueensR(ansList, board, row + 1, n)) {
                    return true;
                }
                board[row][j] = false;
            }
        }
        return false;
    }

    boolean canPlace(int row, int col, boolean[][] board) {

        int i = row;
        int j = col;

        for (i = 0; i < board.length; i++) {
            if (board[row][i] || board[i][col]) {
                return false;
            }
        }

        //check left diagonal
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j--;
        }

        // right diagonal
        i = row;
        j = col;
        while (i >= 0 && j < board.length) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
