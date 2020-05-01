package design.pattern.chainresponsiblity;

public class PositiveProcessor extends Processor {

    public PositiveProcessor(){
        super();
    }

    public PositiveProcessor(Processor processor) {
        super(processor);
    }

    @Override
    public void process(Request reqest) {
        if(reqest.getNumber() > 0){
            System.out.println("PositiveProcessor "+ reqest.getNumber());
        }
        super.process(reqest);
    }


}
