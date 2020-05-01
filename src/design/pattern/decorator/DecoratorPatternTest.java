package design.pattern.decorator;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DecoratorPatternTest {
    public static void main(String[] args) {

        //ClientPopupDecorator popupDecoratored = new ClientPopupDecorator(new ClientLinkDecorator(new ClientReport()));
        //System.out.println(popupDecoratored.getFirstColumnData());

        System.out.println(new SupportReport().getFirstColumnData());
        System.out.println((new SupportLinkDecorator(new SupportReport())).getFirstColumnData());
        System.out.println((new SupportEmailDecorator(new SupportReport())).getFirstColumnData());
        SupportPopupDecorator supportPopupDecoratored =
                new SupportPopupDecorator(new SupportLinkDecorator(new SupportReport()));
        System.out.println(supportPopupDecoratored.getFirstColumnData());

        //

    }
}