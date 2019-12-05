package main.java.structural.decorator;

public class SupportReport implements Report {
    @Override
    public String getReportName(String reportId) {
        return "SupportReport"+reportId;
    }

    @Override
    public String getFirstColumnData() {
        return "Support-Data";
    }
}
