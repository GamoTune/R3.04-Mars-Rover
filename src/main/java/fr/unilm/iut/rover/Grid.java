package fr.unilm.iut.rover;

import java.util.Set;

public class Grid {
    private final int width;
    private final int height;
    private final Set<Coordinate> obstacles;

    public Grid(int width, int height, Set<Coordinate> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public Coordinate normalize(Coordinate potentialPosition) {
        if (potentialPosition.x() < 0) {
            potentialPosition = potentialPosition.add(new Coordinate(width, 0));
        } else if (potentialPosition.x() >= width) {
            potentialPosition = potentialPosition.add(new Coordinate(-width, 0));
        }
        if (potentialPosition.y() < 0) {
            potentialPosition = potentialPosition.add(new Coordinate(0, height));
        } else if (potentialPosition.y() >= height) {
            potentialPosition = potentialPosition.add(new Coordinate(0, -height));
        }

        if (obstacles.contains(potentialPosition)) {
            throw new RuntimeException("Obstacle !");
        }

        // 3. Retourner la coordonnée propre
        return potentialPosition;
    }
}