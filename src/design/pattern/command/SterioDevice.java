package design.pattern.command;

public class SterioDevice implements ElectronicsDevice{
    private  int volume;

    @Override
    public void turnOn() {
        System.out.println("Turning ON SterioDevice");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning OFF SterioDevice");
    }

    @Override
    public void volumeUp() {
        System.out.println("TV volumeUp "+ ++volume);
    }

    @Override
    public void volumeDown() {
        System.out.println("TV volumeDown "+ --volume);
    }
}
