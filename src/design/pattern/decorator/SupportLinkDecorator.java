package design.pattern.decorator;


public class SupportLinkDecorator extends ColumDecorator{

    public SupportLinkDecorator(Report report) {
        super(report);
    }



    private String addMoreInfo(String data){
        return data  + " - support link - ";
    }
}