;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubSet {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,2 , 3);
        List<List<Integer>> ansList = new ArrayList<>();
        findAllSubset(list, ansList, new ArrayList<Integer>(), 0);
        System.out.println(Arrays.toString(ansList.toArray()));

        List<String> ans = new ArrayList<>();
        //findAllStringSubset("abc",);
     }

    private static void findAllSubset(List<Integer> list, List<List<Integer>> ansList, ArrayList<Integer> temp, int start) {

        ansList.add(new ArrayList<>(temp));
        System.out.println(Arrays.toString(temp.toArray()));

        for(int i=start; i < list.size(); i++ ){
            temp.add(list.get(i));
            findAllSubset(list, ansList, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }

    private static void findAllStringSubset(String input, List<String> ansList, String temp, int start) {

        ansList.add(temp);
        System.out.println(temp);

        for(int i=start; i < input.length(); i++ ){
            //temp.add(list.get(i));
            findAllStringSubset(input, ansList, temp+input.charAt(i), i+1);
            //temp.remove(temp.size()-1);
        }
    }
}
