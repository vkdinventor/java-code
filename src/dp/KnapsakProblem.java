package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KnapsakProblem {
    public static void main(String[] args) throws Exception{

        /*
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine()); // c = capacity;

        String[] nums = bf.readLine().split("\\s+");
        int[] values =  new int[n];
        for(int i=0; i < n; i++){
            values[i] = Integer.parseInt(nums[i]);
        }

        nums = bf.readLine().split(" ");
        int[] weight =  new int[n];
        for(int i=0; i < n; i++){
            weight[i] = Integer.parseInt(nums[i]);
        }

         */

        //System.out.println(" "+ t + " n: "+n+" w: "+c);
        //System.out.println(Arrays.toString(values));
        //System.out.println(Arrays.toString(weight));

        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapsakDp(val, wt, W, n));
    }

    public static int knapsak(int[] value, int[] wight, int c, int index, int[][] dp){
        if(index < 0 || c<=0){
            return 0;
        }

        if(dp[index][c] != 0){
            return dp[index][c];
        }

        if(wight[index] > c ){
            dp[index][c] = knapsak(value, wight, c, index-1, dp);
            return dp[index][c];
        }

        dp[index][c] = Math.max(
                knapsak(value, wight, c, index-1, dp),
                value[index] + knapsak(value, wight, c-wight[index], index-1, dp));

        return dp[index][c];
    }

    public static int knapsakDp(int[] value, int[] weight, int c, int n){

        int[][] dp = new int[n+1][c+1];

        for(int i=0; i <= c; i++){
            dp[0][i] = 0;
        }

        for(int i=0; i <= n; i++){
            dp[i][0] = 0;
        }

        for(int i=1; i <= n;  i++){
            for(int j=1; j<=c; j++){
                if(weight[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], value[i-1] + dp[i-1][j-weight[i-1]]);
                }
            }
        }
        return dp[n][c];
    }



    public static int knapsak(int[] value, int[] wight, int c, int index){

        if(index >= value.length || c==0){
            return 0;
        }

        if(wight[index] > c ){
            return knapsak(value, wight, c, index+1);
        }

        return Math.max(
                knapsak(value, wight, c, index+1),
                value[index] + knapsak(value, wight, c-wight[index], index+1));

    }
}
