package design.pattern.command;

public class RemoteController {

    // only one button
    private Command command;

    public RemoteController() {
    }

    public void setCommand(Command command) {
        // set the command the remote will execute
        this.command = command;
    }

    public void buttonPressed() {
        command.execute();
    }
}
