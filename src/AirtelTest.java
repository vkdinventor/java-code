import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AirtelTest {

    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();

        list.add(4,10);
        list.set(4,11);
        Collections.binarySearch(list, 100);
    }
}

abstract class Polygon {
    private List<Double> sides;

    public Polygon(List<Double> sides) {
        this.sides = sides;
    }

    public List<Double> getSides() {
        return sides;
    }

    abstract public double getArea();
}

class Rectangle extends Polygon{

    public Rectangle(double side1, double side2) {
        //List<Double> list = new ArrayList<>();
        super(Arrays.asList(side1, side2));
    }

    @Override
    public double getArea() {
        List<Double> side = getSides();
        return side.get(0) * side.get(1);
    }
}

class A1 {
    public int i;
    protected int j;
}


class B2 extends A1 {
    int j;

    void display() {
        super.j = 3;
        super.i = 10;
        System.out.println(i + " " + j);
    }
}

class TestClass {

    public static void main(String args[]){

        B2 obj = new B2();
        obj.i = 1;
        obj.j = 2;
        obj.display();
    }
}
