package fr.unilm.iut.rover.command;

import fr.unilm.iut.rover.Rover;

public class MoveBackwardCommand implements Command {
    private final Rover rover;

    public MoveBackwardCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.moveBackward();
    }
}
