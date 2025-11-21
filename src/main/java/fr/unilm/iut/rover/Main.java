package fr.unilm.iut.rover;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Lancement de la Mission Mars Rover ---");

        // 1. Création des obstacles
        Set<Coordinate> obstacles = new HashSet<>();
        obstacles.add(new Coordinate(10, 10));
        obstacles.add(new Coordinate(0, 3));

        // 2. Initialisation de la Grille
        Grid marsGrid = new Grid(100, 100, obstacles);

        // 3. Création du Rover
        Rover spirit = new Rover(marsGrid, new Coordinate(0, 0), Direction.NORTH);

        System.out.println("État initial : " + spirit.getState());

        // 4. Création du Contrôleur
        RoverController houston = new RoverController(spirit);

        // 5. Envoi des commandes
        String commands = "ffrff";
        System.out.println("Envoi des commandes : " + commands);

        houston.executeCommands(commands);

        // 6. Vérification du résultat
        System.out.println("État final : " + spirit.getState());
    }
}