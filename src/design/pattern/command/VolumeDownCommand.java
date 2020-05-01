package design.pattern.command;

public class VolumeDownCommand implements Command {

    private ElectronicsDevice device;

    public VolumeDownCommand(ElectronicsDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.volumeUp();
    }
}
