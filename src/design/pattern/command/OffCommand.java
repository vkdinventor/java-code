package design.pattern.command;

public class OffCommand implements Command {

    private ElectronicsDevice device;

    public OffCommand(ElectronicsDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}
