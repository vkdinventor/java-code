package design.pattern.chainresponsiblity;

public class ChainOfResponsibiltyDemo {

    public static void main(String[] args){

        //Chain chain = new Chain(new NegativeProcessor(new PositiveProcessor(null)));
        Chain chain = new Chain(new PositiveProcessor(new NegativeProcessor(null)));

        chain.process(new Request(100));
        chain.process(new Request(-200));
        chain.process(new Request(300));
        chain.process(new Request(-400));

        Processor processor = new PositiveProcessor();
        processor.setNextProcessort(new NegativeProcessor());

        chain = new Chain(processor);

        chain.process(new Request(100));
        chain.process(new Request(-200));
        chain.process(new Request(300));
        chain.process(new Request(-400));
    }
}
