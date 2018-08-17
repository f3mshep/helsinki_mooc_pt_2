package dungeon.logic;

import java.util.List;

public abstract class Character {

    private int x, y;

    public abstract String getToken();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getLocation(){
        int[] coord = {x, y};
        return coord;
    }

    @Override
    public String toString() {
        return this.getToken() + " " + this.getX() + " " + this.getY();
    }

    public abstract boolean allowedToMove();

}
