import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/palindrome-partitioning/
 */
public class PalindromePartition {

    public static void main(String[] args){
        String input = "efe";
        List<List<String>> ansList = new ArrayList<>();
        backtrack(input, ansList, new ArrayList<>(), 0);
        //System.out.println(ansList.toArray());

    }

    public static void backtrack(String str, List<List<String>> ansList, List<String> tempList, int index){

        if(index  >= str.length()){
            System.out.println(Arrays.toString(tempList.toArray()));
            ansList.add(new ArrayList<>(tempList));
            return;
        }

        for(int i= index; i < str.length(); i++){
            String temp = str.substring(index, i+1);
            if(isPalindrom(temp)){
                tempList.add(temp);
                backtrack(str, ansList, tempList, i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static boolean isPalindrom(String str){

        int left = 0;
        int right = str.length()-1;
        while(left <= right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
