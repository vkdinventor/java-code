package design.pattern.command;

import java.util.stream.Stream;

public class CommandPatternTest {

    public static void main(String[] args){

        ElectronicsDevice television = new Television();
        ElectronicsDevice streo = new SterioDevice();

        RemoteController remoteController = new RemoteController();
        remoteController.setCommand(new OnCommand(television));
        remoteController.buttonPressed();
        remoteController.setCommand(new OnCommand(streo));
        remoteController.buttonPressed();

        remoteController.setCommand(new OffCommand(television));
        remoteController.buttonPressed();
        remoteController.setCommand(new OffCommand(streo));
        remoteController.buttonPressed();
    }
}
