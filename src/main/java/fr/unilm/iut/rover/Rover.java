package fr.unilm.iut.rover;

public class Rover {
    private Coordinate position;
    private Direction direction;
    private final Grid grid;

    public Rover(Grid grid, Coordinate startPos, Direction startDir) {
        this.grid = grid;
        this.position = startPos;
        this.direction = startDir;
    }

    public void moveForward() {
        Coordinate newPosition = this.position.add(this.direction.vector());
        this.position = grid.normalize(newPosition);
        
    }

    public void moveBackward() {
        Coordinate newPosition = this.position.add(new Coordinate(-this.direction.vector().x(), -this.direction.vector().y()));
        this.position = grid.normalize(newPosition);
        
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    // Getters pour l'affichage
    public String getState() {
        return position.toString() + " facing " + direction;
    }
}
