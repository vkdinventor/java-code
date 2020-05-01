package design.pattern.command;

public class OnCommand implements Command {

    private ElectronicsDevice device;

    public OnCommand(ElectronicsDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
