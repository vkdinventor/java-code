package dp;

import java.util.Arrays;

public class LongestComnSubSeq {

    public static void main (String[] args){

        System.out.println(lcsDp("ABCDGH", "AEDFHR"));
        System.out.println(lcsRec("ABCDGH", "AEDFHR",0, 0));
    }

    public static int lcsDp(String str1, String str2){

        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=1; i <= n; i++){
            for (int j= 1; j <= m; j++){
                if(str1.charAt(j-1) == str2.charAt(i-1)){
                    dp[i][j] = 1 + Math.max(dp[i][j-1],dp[i-1][j]); // or simply 1 + dp[i-1][j-1]
                }else {
                    dp[i][j] =  Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        for(int i=0; i <=n; i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        int i= n;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j >0){
            if(str1.charAt(j-1) == str2.charAt(i-1)){
                sb.insert(0,str1.charAt(j-1));
                i--;
                j--;
            }else {
                if(dp[i][j-1] > dp [i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        System.out.println(sb);
        return dp[n][m];
    }

    public static int lcsRec(String str1, String str2, int l1, int l2){

        if(l1 >= str1.length() || l2 >= str2.length()){
            return 0;
        }

        if(str1.charAt(l1) == str2.charAt(l2)){
            return 1 + lcsRec(str1, str2, l1+1, l2+1);
        }
        return Math.max(lcsRec(str1, str2, l1, l2+1), lcsRec(str1, str2, l1+1, l2));
    }
}
