package fr.unilm.iut.rover;


public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction turnLeft() {
        return getDirection(WEST, EAST);
    }

    public Direction turnRight() {
        return getDirection(EAST, WEST);
    }

    private Direction getDirection(Direction direction, Direction direction2) {
        if (this == NORTH) {
            return direction;
        } else if (this == direction) {
            return SOUTH;
        } else if (this == SOUTH) {
            return direction2;
        } else if (this == direction2) {
            return NORTH;
        }
        return null;
    }

    public Coordinate vector() {
        switch (this) {
            case NORTH:
                return new Coordinate(0, 1);  // Y augmente vers le haut
            case EAST:
                return new Coordinate(1, 0);  // X augmente vers la droite
            case SOUTH:
                return new Coordinate(0, -1); // Y diminue vers le bas
            case WEST:
                return new Coordinate(-1, 0); // X diminue vers la gauche
            default:
                return new Coordinate(0, 0);
        }
    }
}