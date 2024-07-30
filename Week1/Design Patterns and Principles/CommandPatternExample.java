// CommandPatternExample.java

// Command Interface
interface Command {
    void execute();
}

// Receiver Class
class Light {
    public void turnOn() {
        System.out.println("Light is turned ON");
    }

    public void turnOff() {
        System.out.println("Light is turned OFF");
    }
}

// Concrete Commands
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Invoker Class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Test the Command Pattern
public class CommandPatternExample {
    public static void main(String[] args) {
        // Create a light (receiver)
        Light light = new Light();

        // Create command objects
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        // Issue commands
        remote.setCommand(lightOn);
        System.out.println("Issuing Light On Command:");
        remote.pressButton();

        remote.setCommand(lightOff);
        System.out.println("Issuing Light Off Command:");
        remote.pressButton();
    }
}
