package dp;

import java.util.ArrayList;

public class ContinousSubArraySum {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1000000000);
        solve(list, 1000000000);
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        ArrayList<Integer> ansList = new ArrayList<>();
        int right = 1;
        int left = 0;
        long sum = A.get(left);
        ansList.add(A.get(left));

        while (left < right && right < A.size()) {

            sum = sum % 1000000000;
            int b = A.get(right);
            ansList.add(b);
            sum = sum + b;

            while (sum > B) {
                sum = sum - ansList.get(0);
                ansList.remove(0);
                left++;
            }

            if (sum == B) {
                return ansList;
            }
            right++;
        }
        ansList = new ArrayList<>();
        ansList.add(-1);
        return ansList;
    }
}
