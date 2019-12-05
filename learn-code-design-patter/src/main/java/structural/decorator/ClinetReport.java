package main.java.structural.decorator;

public class ClinetReport implements Report {
    @Override
    public String getReportName(String reportId) {
        return "ClinetReport"+reportId;
    }

    @Override
    public String getFirstColumnData() {
        return "ClinetReport";
    }
}
