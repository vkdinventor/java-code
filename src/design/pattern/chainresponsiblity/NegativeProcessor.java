package design.pattern.chainresponsiblity;

public class NegativeProcessor extends Processor {

    NegativeProcessor(){
        super();
    }

    NegativeProcessor(Processor processor){
        super(processor);
    }

    @Override
    public void process(Request reqest) {
        if(reqest.getNumber() < 0){
            System.out.println("NegativeProcessor "+ reqest.getNumber());
        }
        super.process(reqest);
    }
}
