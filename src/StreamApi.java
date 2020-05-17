import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StreamApi {

    public static void main(String[] args) throws Exception{

        List<String> person = Arrays.asList("abc", "DEF", "AesF", "GADESAD", "DSDGEW", "OPSIF");

        person.stream().peek(System.out::println).forEach(System.out::println);
        person.stream().reduce(String::concat).get();

        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        Arrays.stream(arr).sum();

        // for primitive use sum() for Interger non primitive use reduce;

        person.stream().mapToInt( v -> 1).sum();

        person.stream()
                .map( v -> v.toLowerCase())
                .filter( v -> v.startsWith("a"))
                .forEach(System.out::println);

        //person.forEach();

        File file = new File("hello.txt");
        if(!file.exists()){
            file.createNewFile();
        }

        Files.lines(Paths.get("hello.txt")).forEach(System.out::println);

        Map<String, String> map  = Files.lines(Paths.get("data.txt"))
                .map(x -> x.split(" "))
                .filter(x -> Integer.parseInt(x[1]) > 10)
                .collect(Collectors.toMap( x-> x[0], x -> Arrays.toString(x)));

        map.forEach((k, v) -> System.out.println(k+" -> "+v));

        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        //salaries.entrySet().stream().


        salaries.replaceAll((name, oldValue) ->
                name.equals("Freddy") ? oldValue : oldValue + 10000);
        System.out.println("Salary");
        salaries.forEach((k, v) -> System.out.println(k+" -> "+v));
    }
}
