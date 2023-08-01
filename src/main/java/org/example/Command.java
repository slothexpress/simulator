package org.example;

public enum Command {
    QUIT(0),
    FORWARD(1),
    BACKWARD(2),
    ROTATE_CLOCKWISE(3),
    ROTATE_COUNTERCLOCKWISE(4);

    private final int value;

    Command(int value) {
        this.value = value;
    }

    public static Command fromValue(int value) {
        for (Command command : Command.values()) {
            if (command.value == value) {
                return command;
            }
        }
        throw new IllegalArgumentException("Invalid Command: " + value);
    }
}