import java.io.IOException;
import java.util.Comparator;

public class OverridingTest {

    public static void main(String[] args){

        A test = new B();
        A a = new A();
        B b = new B();
        //B ba = new A();
        System.out.println("exit");

    }
}

class A {
    public void someMethod() throws IOException {
        System.out.println("class A");
    }
}

class B extends A {

    // it can't throw exception of highter bucket like Exception
    // it can't restrict access.
    @Override
    public void someMethod() {
        System.out.println("class B");
    }


    public void sayHi() {
        System.out.println("class B says Hi");
    }
}

class D implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}

class E implements Comparable<Integer> {

    @Override
    public int compareTo(Integer o) {
        return 0;
    }


}