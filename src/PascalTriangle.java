;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PascalTriangle {
    public static void main(String[] args){

        System.out.print(Arrays.toString(PascalTriangleUtil.getRow(3).toArray()));
        Integer[] arr = new Integer[]{5,4, 3, 4, 5};
        System.out.println(PascalTriangleUtil.maxSpecialProduct(Arrays.asList(arr)));
    }
}

class PascalTriangleUtil {
    public static ArrayList<Integer> getRow(int A) {

        ArrayList<Integer> list = new ArrayList<>();
        int[][] result = new int[A + 1][A + 1];

        for (int line = 0; line <= A; line++) {
            for (int index = 0; index <= line; index++) {
                if (line == index || index==0){
                    result[line][index]=1;
                }else {
                    result[line][index] = result[line - 1][index - 1] + result[line - 1][index];
                }
                System.out.print(result[line][index]+" ");
            }
            System.out.println();
            Integer.toBinaryString(100);
        }

        return list;
    }

    public static int maxSpecialProduct(List<Integer> arr) {
        // {5,4, 3, 4, 5};
        int n = arr.size();
        int[] left = new int[n];  //index j such that A[j]>A[i] (j<i).
        int[] right = new int[n]; // index j such that A[j]>A[i] (j>i).

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty()) {
                if (arr.get(stack.peek()) < arr.get(i)) {
                    break;
                }
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }

        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (arr.get(stack.peek()) > arr.get(i)) break;
                stack.pop();
            }
            right[i] = (stack.isEmpty()) ? 0 : stack.peek();
            stack.push(i);
        }
        long mx = -1;
        for (int i = 0; i < n; i++) {
            mx = Long.max(mx, (long) left[i] * right[i]);
        }
        return (int) (mx % 1000000007);
    }

}
