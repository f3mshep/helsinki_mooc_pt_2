package dungeon.logic;

public class Player extends Character {

    private String token;

    public Player() {
        this.token = "@";
        setX(0);
        setY(0);
    }

    @Override
    public String getToken() {
        return this.token;
    }

    @Override
    public boolean allowedToMove() {
        return true;
    }
}
