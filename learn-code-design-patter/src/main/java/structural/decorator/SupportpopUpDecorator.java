package main.java.structural.decorator;

public class SupportpopUpDecorator extends ColumnDecorator {

    public SupportpopUpDecorator(Report report) {
        super(report);
    }

    public String getFirstColumnData() {
        return addPopup (super.getFirstColumnData()) ;
    }

    private String addPopup(String data){
        return data  + " - support popup - ";
    }


}
