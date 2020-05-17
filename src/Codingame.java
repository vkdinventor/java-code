import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.math.*;


public class Codingame {
}


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class SolutionNew {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numberOfDays = in.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numberOfDays; i++) {
            String ingredient = in.next();
            list.add(ingredient);
        }
        calculate(list);
    }


    static void calculate(List<String> list){
        // FIBER, FAT, CARB,
        List<Item> fiber = new ArrayList<>();
        List<Item> fat = new ArrayList<>();
        List<Item> carb = new ArrayList<>();


        for(int i = 0; i < list.size(); i++){
            String temp = list.get(i);
            if(temp.startsWith("FIBER")){
                fiber.add(new Item(i, temp));
            }else if(temp.startsWith("FAT")){
                fat.add(new Item(i, temp));
            }else{
                carb.add(new Item(i, temp));
            }

            int ans = 0;
            int a = fat.stream().min(Comparator.comparingInt(x -> x.index)).get().index;
            if((fat.size() + carb.size()) >= 3){
                if(carb.size() >= 2 && fat.size() >= 1){
                    carb.remove(0);
                    carb.remove(0);
                    fat.remove(0);
                    ans = 1;
                }else if(fat.size() >= 2 && carb.size() >= 1) {
                    fat.remove(0);
                    fat.remove(0);
                    carb.remove(0);
                    ans = 1;
                }
            }
            if((fiber.size() + carb.size()) >= 3){

                if(carb.size() >= 2 && fiber.size() >= 1){
                    carb.remove(0);
                    carb.remove(0);
                    fiber.remove(0);
                    ans = 1;
                }else if(fiber.size() >= 2 && carb.size() >= 1){
                    fiber.remove(0);
                    fiber.remove(0);
                    carb.remove(0);
                    ans = 1;
                }

            }
            if((fat.size() + fiber.size()) >= 3){

                if(fiber.size() >= 2 && fat.size() >=1){
                    fiber.remove(0);
                    fiber.remove(0);
                    fat.remove(0);
                    ans = 1;
                }else if(fat.size() >= 2 && fiber.size() >=1){
                    fat.remove(0);
                    fat.remove(0);
                    fiber.remove(0);
                    ans = 1;
                }
            }

            System.out.print(ans);
        }
    }
}

class Item {
    int index;
    String name;

    public Item(int index, String name) {
        this.index = index;
        this.name = name;
    }
}

