package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 * Backtracking solution {@link backtracking.SubsetSum}
 */
public class SubsetSumDp {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 34, 4, 12, 5, 2);
        boolean ans = isSubsetSumFound(list,9);
        System.out.println(ans);
    }

    //row has no use
    private static boolean isSubsetSumFound(List<Integer> list, int sum) {

        boolean[][] subsetSum = new boolean[sum+1][list.size()+1];

        for(int i = 0; i <= sum; i++){
            subsetSum[i][0] = false;
        }

        for(int i = 0; i <= list.size(); i++){
            subsetSum[0][i] = true;
        }

        for(int i = 1; i <= sum; i++){
            for(int j= 1; j <= list.size(); j++){
                subsetSum[i][j] = subsetSum[i][j-1];
                if(i >= list.get(j-1)){
                    subsetSum[i][j] = subsetSum[i][j-1] || subsetSum[i-list.get(j-1)][j-1];
                }
            }
        }
        for(int i=0; i<= sum; i++){
            System.out.println(Arrays.toString(subsetSum[i]));
        }
        return subsetSum[sum][list.size()];
    }

}

