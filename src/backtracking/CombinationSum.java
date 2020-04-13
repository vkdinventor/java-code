package backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Subset sum -> no repeat
 * https://www.interviewbit.com/problems/combination-sum-ii/
 */
public class CombinationSum {

    public static void main(String[] args){
        List<Integer> list  =  Arrays.asList(10, 1, 2, 7, 6, 1, 5);

        ArrayList<ArrayList<Integer>> ansList = combinationSum( new ArrayList<>(list), 8);

        for(ArrayList tempList : ansList){
            System.out.println(Arrays.asList(tempList.toArray()));
        }
    }


    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> list, int sum) {

        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        Collections.sort(list);
        combinationSumR2(list, ansList, new ArrayList<>(), sum, 0);
        return ansList;
    }

    public static void combinationSumR2(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ansList, ArrayList<Integer> row,
                                 int sum,int index){
        if (sum < 0){
            return;
        }
        if (sum == 0){
            if (!ansList.contains(row)) {
                ansList.add(new ArrayList<>(row));
            }
            return;
        }

        // set index == 0 if repetition is allowed
        // @See https://www.interviewbit.com/problems/combination-sum/
        for(int i = index; i < list.size(); i++){
            row.add(list.get(i));
            combinationSumR2(list, ansList, row, sum - list.get(i),index);
            row.remove(row.size()-1);

        }
    }


    public static void combinationSumR(ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ansList, ArrayList<Integer> row,
                                int sum, boolean[] marked) {

        if (sum == 0) {
            ArrayList<Integer> arr = new ArrayList<>(row);
            Collections.sort(arr);
            if (!ansList.contains(arr)) {
                ansList.add(arr);

            }
            return;
        }

        if (sum < 0) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!marked[i]) {
                marked[i] = true;
                row.add(list.get(i));
                combinationSumR(list, ansList, row, sum - list.get(i), marked);
                marked[i] = false;
                row.remove(row.size() - 1);
            }
        }
    }
}
