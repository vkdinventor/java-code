package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MaxSumWithoutAdjacent {

    public static int maxSum = Integer.MIN_VALUE;
    public static int maxSum2 = Integer.MIN_VALUE;

    public static void main(String[] args) {
        //Integer[] arr = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };  //26
        Integer[] arr = {1, 6, 4};
        maxSumWithoutAdjacent(Arrays.asList(arr), new ArrayList<>(), 0, Integer.MIN_VALUE);

        maxSumWithoutAdjacent(Arrays.asList(arr), 0, 0, Integer.MIN_VALUE);
        System.out.println(maxSum + " " + maxSum2);

        System.out.println(maxSumWithoutAdjacent(Arrays.asList(arr), 0, Integer.MIN_VALUE));

        Integer[] arr2 = {1, 2, 3, 4};
        Integer[] arr3 = {2, 3, 4, 5};

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(arr2));
        list.add(Arrays.asList(arr3));

        System.out.println(adjacent(list, 0, Integer.MIN_VALUE));

    }


    public static void maxSumWithoutAdjacent(List<Integer> list, List<Integer> ansList, int index, int prevIndex) {

        System.out.println(Arrays.toString(ansList.toArray()));
        int sum = ansList.stream().reduce(0, Integer::sum);
        maxSum = Math.max(sum, maxSum);

        for (int i = index; i < list.size(); i++) {
            if (prevIndex + 1 != i) {
                ansList.add(list.get(i));
                maxSumWithoutAdjacent(list, ansList, i + 1, i);
                ansList.remove(ansList.size() - 1);
            }
        }
    }

    public static void maxSumWithoutAdjacent(List<Integer> list, int tempSum, int index, int prevIndex) {

        maxSum2 = Math.max(maxSum2, tempSum);
        for (int i = index; i < list.size(); i++) {
            if (prevIndex + 1 != i) {
                maxSumWithoutAdjacent(list, tempSum + list.get(i), i + 1, i);
            }
        }
    }

    public static int maxSumWithoutAdjacent(List<Integer> list, int index, int prevIndex) {

        if (index >= list.size()) {
            return 0;
        }

        return Math.max(list.get(index) + maxSumWithoutAdjacent(list, index + 2, index),
                maxSumWithoutAdjacent(list, index + 1, prevIndex));


    }

    public static int adjacent(List<List<Integer>> list, int index, int prevIndex) {

        /*
        Integer[] arr2 = {1, 2, 3, 4};
        Integer[] arr3 = {2, 3, 4, 5};
         */

        if (index >= list.size()) {
            return 0;
        }

        if (index != 1 + prevIndex) {
            return Math.max(Math.max(list.get(0).get(index),list.get(1).get(index) ) + adjacent(list, index + 1, index),
                    adjacent(list, index + 1, prevIndex));
        } else {
            return adjacent(list, index + 1, prevIndex);
        }
    }
}
