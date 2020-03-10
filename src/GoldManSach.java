;

import java.util.HashMap;
import java.util.Map;

public class GoldManSach {



    public static void main (String[] args){

        String [][] score = new String[][] {{"vikash 1", "50"}, {"vikash 1", "100"},{"vikash 1", "70"}};

        Map<String, Double> map = new HashMap<>();

        for(int i = 0; i < score.length; i++){

            Double val = map.get(score[i][0]);
            if (val != null){
                val = (val + Double.parseDouble(score[i][1]))/2;
                map.put(score[i][0], val);
            } else {
                map.put(score[i][0],Double.parseDouble(score[i][1]));
            }

        }

        int a = 0;
        for (Map.Entry<String, Double> m : map.entrySet()){
            if (m.getValue().intValue() > a){
                a = m.getValue().intValue();
            }
        }

        System.out.println(a);

    }
}
