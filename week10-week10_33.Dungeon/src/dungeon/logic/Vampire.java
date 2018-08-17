package dungeon.logic;

public class Vampire extends Character {

    private String token;
    private boolean canMove;

    public Vampire(int x, int y, boolean canMove) {
        this.token = "v";
        this.canMove = canMove;
        setX(x);
        setY(y);
    }

    @Override
    public String getToken() {
        return this.token;
    }

    @Override
    public boolean allowedToMove() {
        return this.canMove;
    }
}
