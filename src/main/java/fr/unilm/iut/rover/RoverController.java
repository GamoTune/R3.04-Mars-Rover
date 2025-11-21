package fr.unilm.iut.rover;

import fr.unilm.iut.rover.command.*;

import java.util.ArrayList;
import java.util.List;

public class RoverController {
    private final Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
    }

    public void executeCommands(String commandString) {
        List<Command> commands = parseCommands(commandString);

        for (Command cmd : commands) {
            try {
                cmd.execute();
            } catch (RuntimeException e) {
                System.out.println("Erreur rencontrée (Obstacle) : " + e.getMessage());
                break;
            }
        }
    }

    private List<Command> parseCommands(String commandString) {
        List<Command> list = new ArrayList<>();
        for (char c : commandString.toCharArray()) {
            switch (c) {
                case 'f' -> list.add(new MoveForwardCommand(rover));
                case 'b' -> list.add(new MoveBackwardCommand(rover));
                case 'l' -> list.add(new TurnLeftCommand(rover));
                case 'r' -> list.add(new TurnRightCommand(rover));
                default -> System.out.println("Commande inconnue : " + c);
            }
        }
        return list;
    }
}