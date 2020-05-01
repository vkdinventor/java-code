package design.pattern.chainresponsiblity;

public abstract class Processor {


    private Processor processor;

    public Processor(Processor processor) {
        this.processor = processor;
    }

    public void process(Request request){
        if(processor != null){
            processor.process(request);
        }
    }

    //// instead of constructor we can use next to set processor
    public Processor() {
    }

    public Processor setNextProcessort(Processor processor){
        this.processor = processor;
        return this.processor;
    }
}
