import java.io.IOException;
import java.util.Comparator;

public class OverridingTest {

    public static void main(String[] args) throws Exception{

        A test = new B();
        A a = new A();
        B b = new B();
        //B ba = new A();
        test.someMethod();
        a.someMethod();
        b.someMethod();
        System.out.println("exit");

        //new AbstractClass().sayHello();

    }
}

class A {

    int i;

    public A() {
        i = 10;
        System.out.println("Class A constuctor");
    }

    public void someMethod() throws IOException {
        System.out.println("class A");
    }
}

class B extends A {

    int i;

    public B() {
        System.out.println("Class B constuctor");
    }
    // it can't throw exception of highter bucket like Exception
    // it can't restrict access.
    @Override
    public void someMethod() {
        System.out.println("class B and i is "+i);
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

interface  FunA {
    default void speak(){
        System.out.print("Speak form FunA");
    }
}

interface  FunB {
    default void speak(){
        System.out.print("Speak form FunB");
    }
}

class  FunctionC implements FunA, FunB {
    // Override is must here. Otherwise it will show error function inherit unrelated method.
    @Override
    public void speak() {

    }

    public int countInterface(){
        return 0;
    }

}

abstract class AbstractClass {

    public void sayHello(){
        System.out.println("Hello world");
    }
}