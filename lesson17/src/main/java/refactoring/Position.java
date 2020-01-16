package refactoring;

public class Position {
    int x;
    int y;
    Position(int x, int y){
        this.x = x;
        this.y=y;
    }

    public int getPositionX() {
        return x;
    }

    public int getPositionY() {
        return y;
    }
}
