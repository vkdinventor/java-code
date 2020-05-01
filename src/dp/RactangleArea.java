package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


class Solution {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> list) {
        int ans = 0;
        int row = list.size();
        int col = list.get(0).size();
        int[][] dp = new int[1 + row][1 + col];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (list.get(i - 1).get(j - 1) == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }

        return dp[row][col];
    }
}

//Java program to find maximum rectangular area in linear time


public class RactangleArea {
    // The main function to find the maximum rectangular area under given
    // histogram with n bars
    static int getMaxArea(Integer hist[]) {

        Stack<Integer> stack = new Stack<>();
        int n = hist.length;
        int maxArea = 0;
        int top;
        int area;
        int i = 0;

        while (i < n) {
            // If this bar is higher than the bar on top stack, push it to stack
            if (stack.empty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i++);
            } else {
                top = stack.pop();
                // Calculate the area with hist[tp] stack as smallest bar
                area = hist[top] * (stack.empty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }
        }

        // Now pop the remaining bars from stack and calculate area with every popped bar as the smallest bar
        while (!stack.empty()) {
            top = stack.pop();
            area = hist[top] * (stack.empty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;

    }

    public static int getHistogramArea(List<Integer> list){

        int size = list.size();
        int maxArea = 0;
        int i = 0;

        Stack<Integer> stack = new Stack<>();
        while (i < size){

            if(stack.isEmpty() || list.get(stack.peek()) <= list.get(i)){
                stack.push(i);
                i++;
            }else{
                int top = stack.pop();
                int area = list.get(top) * ( stack.isEmpty() ? i : i-stack.peek() -1 );
                maxArea = Math.max(maxArea, area);
            }
        }

        while(!stack.isEmpty()){
            int top = stack.pop();
            int area = list.get(top) * ( stack.isEmpty() ? i : i-stack.peek() -1 );
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    // Driver program to test above function
    public static void main(String[] args) {
        Integer hist[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Maximum area is " + getMaxArea(hist));
        System.out.println("Maximum area is " + getHistogramArea(Arrays.asList(hist)));
    }
}
//This code is Contributed by Sumit Ghosh
