package main.java.structural.decorator;

public class DecoratorPatterTest {

    public static void main(String[] args) {
        SupportpopUpDecorator supportpopUpDecorator=new SupportpopUpDecorator(new SupportLinkDecorator(new SupportReport()));
        System.out.println(" "+supportpopUpDecorator.getFirstColumnData());
    }
}
