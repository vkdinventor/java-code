package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * This solution uses backtracking.
 * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class SubsetSum {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 34, 4, 12, 5, 2);
        boolean ans = isSubsetSumFound(list, new ArrayList<Integer>(), 10, 0);
        System.out.println(ans);
    }

    //row has no use
    private static boolean isSubsetSumFound(List<Integer> list, List<Integer> row, int sum, int index) {

        if (sum < 0) {
            return false;
        }

        if (sum == 0) {
            System.out.println(Arrays.toString(row.toArray()));
            return true;
        }

        for (int i = index; i < list.size(); i++) {
            boolean without = isSubsetSumFound(list, row, sum, i + 1);
            row.add(list.get(i));
            boolean with = isSubsetSumFound(list, row, sum - list.get(i), i + 1);
            if (with || without) {
                return true;
            }
            row.remove(row.size() - 1);
        }
        return false;
    }

}
