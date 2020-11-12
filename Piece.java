package Chess;

public abstract class Piece {

    protected Color color;
    protected char icon;
    private boolean alive;

    public Piece (Color color){
        this.color = color;
        this.alive = true;
    }

    public abstract boolean isValidMovement(Coordinate origin, Coordinate destination);

    public Color getColor(){
        return this.color;
    }

    public char show(){
        System.out.print(' ');
        return this.icon;
    }

    public void kill(){
        this.alive = false;
    }

    public boolean isAlive(){
        return this.alive;
    }

    public abstract boolean isKing();
}
