package dp;

import java.util.Scanner;

class LongestCommonSub {
    public static void main (String[] args) {
        //code
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(lcs2(s1,s2, s1.length(), s2.length()));
        System.out.println(lcs(s1,s2, s1.length(), s2.length()));

    }

    public static int lcs(String s1, String s2, int l, int m){
        if (l <= 0 || m <= 0){
            return 0;
        }

        if( s1.charAt(l-1) == s2.charAt(m-1)){
            return (1 + lcs (s1, s2, l-1, m-1) );
        }else {
            return Math.max(lcs(s1, s2, l, m-1),lcs(s1, s2, l-1, m));
        }

    }

    public static int lcs2(String s1, String s2, int m, int n) {

        int[][] matrix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                else
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }
        return matrix[m][n];
    }
}