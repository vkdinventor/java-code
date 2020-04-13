package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetPartition {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 3, 4, 2, 8, 1, 9, 6);

        boolean isHalf = false;
        int sum = list.stream().reduce(0, Integer::sum);
        List<Integer> ansList = new ArrayList<>();
        if (sum % 2 == 0) {
            isHalf = isValid(list, sum / 2, ansList);
        }

        ansList.stream().peek(System.out::println);
        list = new ArrayList<>(list);
        list.removeAll(ansList);
        System.out.println(isHalf + " sum :" + sum + " " + Arrays.toString(ansList.toArray()) + " " + Arrays.toString(list.toArray()));

    }


    static boolean isValid(List<Integer> list, int sum, List<Integer> ansList) {

        if (sum == 0) {
            return true;
        }
        if (sum > 0) {
            for (Integer a : list) {
                if (!ansList.contains(a)) {
                    ansList.add(a);
                    boolean isTrue = isValid(list, sum - a, ansList);
                    if (isTrue) {
                        return true;
                    }
                    ansList.remove(a);
                }
            }
        }
        return false;
    }
}


