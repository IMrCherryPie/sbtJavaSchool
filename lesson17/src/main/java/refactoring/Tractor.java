package refactoring;

public class Tractor {
    Position position = new Position(0,0);
    int[] field = new int[] { 5, 5 };
    Orientation orientation = Orientation.NORTH;

    public void move(String command) {
        if (command == "F") {
            moveForwards();
        } else if (command == "T") {
            turnClockwise();
        }
    }

    public void moveForwards() {//можно переделать
        if (orientation == Orientation.NORTH) {
            position = new Position(0, position.getPositionY() + 1 );
            return;
        }
        if (orientation == Orientation.EAST) {
            position = new Position(position.getPositionX() + 1, position.getPositionY());
            return;
        }
        if (orientation == Orientation.SOUTH) {
            position = new Position(position.getPositionX(), position.getPositionY() - 1);
            return;
        }
        if (orientation == Orientation.WEST) {
            position = new Position(position.getPositionX() - 1, position.getPositionY());
            return;
        }
        if (position.getPositionX() > field[0] || position.getPositionY() > field[1]) {
            throw new TractorInDitchException();
        }
    }

    public void turnClockwise() {
        switch (orientation) {
            case NORTH:
                    orientation = Orientation.EAST;
                break;
            case EAST:
                orientation = Orientation.SOUTH;
                break;
            case WEST:
                orientation = Orientation.NORTH;
                break;
            case SOUTH:
                orientation = Orientation.WEST;
                break;
        }
    }
    public Orientation getOrientation() {
        return orientation;
    }
    // Конструктор, не содавать кажлый раз новый объект int[]
    // создать position класс, внутри методы get set
    // operation сделать через switch case
    // класс филд содержащий X Y и проверку на размерность? методы Field(x,y)
    // можносделать интерфесы, но их пока не надо -_-
}
