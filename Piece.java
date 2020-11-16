package Chess;

public abstract class Piece {

    protected Color color;
    protected char icon;
    private boolean alive;

    public Piece (Color color){
        this.color = color;
        this.alive = true;
    }

    public abstract boolean isValidMovement(Board board, Coordinate origin, Coordinate destination);

    public Color getColor(){
        return this.color;
    }

    public char show(){
        return this.icon;
    }

    public void kill(){
        this.alive = false;
    }

    public void killPiece(Piece piece){
        piece.kill();
    }

    public boolean isAlive(){
        return this.alive;
    }

    public abstract boolean isKing();
}
