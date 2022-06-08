package main.java.structural.decorator;

public abstract class ColumnDecorator implements Report {

private Report report;

    public ColumnDecorator(Report report) {
        this.report = report;
    }

    @Override
    public String getReportName(String reportId) {
        return this.report.getReportName(reportId);
    }

    @Override
    public String getFirstColumnData() {
        return this.report.getFirstColumnData();
    }
}
