package design.pattern.chainresponsiblity;

public class Chain {

    Processor processor;

    Chain(Processor processor){
        this.processor = processor;
    }

    public void process(Request request){
        processor.process(request);
    }

}
