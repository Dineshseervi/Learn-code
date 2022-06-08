package main.java.structural.decorator;

public class DecoratorPatterTest {

    public static void main(String[] args) {
        Report report=new SupportpopUpDecorator(new SupportLinkDecorator(new SupportReport()));
        System.out.println(" "+report.getFirstColumnData());
    }
}
