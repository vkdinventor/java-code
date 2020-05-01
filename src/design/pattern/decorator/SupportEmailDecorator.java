package design.pattern.decorator;

public class SupportEmailDecorator extends ColumDecorator {

    public SupportEmailDecorator(Report report) {
        super(report);
    }

    @Override
    public String getFirstColumnData() {
        return addInfo(super.getFirstColumnData());
    }

    private String addInfo(String firstColumnData) {
        return firstColumnData + "Email Decorator";
    }

    @Override
    public Object[][] getReportData(String reportId) {
        return super.getReportData(reportId);
    }
}
