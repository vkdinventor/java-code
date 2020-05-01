package design.pattern.command;

public class VolumeUpCommand implements Command {
    private ElectronicsDevice device;

    public VolumeUpCommand(ElectronicsDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.volumeUp();
    }
}
