import java.util.Stack;
import java.util.stream.IntStream;

public class TowerOfHanoi {

    static Stack<Integer> source = new Stack<>();
    static Stack<Integer> temp = new Stack<>();
    static Stack<Integer> dest = new Stack<>();

    public static void main(String[] args){


        for(int i=3; i> 0; i--){
            source.push(i);
        }

        System.out.println("Before solving");
        System.out.println(source.toString());
        System.out.println(temp.toString());
        System.out.println(dest.toString());

        solve(source.size(), source, dest, temp);
        System.out.println("After solving");
        System.out.println(source.toString());
        System.out.println(temp.toString());
        System.out.println(dest.toString());
    }

    public static void solve(int n, Stack<Integer> source, Stack<Integer> dest, Stack<Integer> temp){
        if(n == 0){
            return;
        }
        solve(n-1, source, temp, dest);
        dest.push(source.pop());
        solve(n-1, temp, dest, source);
    }

}
