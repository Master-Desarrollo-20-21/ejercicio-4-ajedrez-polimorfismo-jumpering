package Chess;

public class Pawn extends Piece{

    public Pawn(Color color){
        super(color);
        if (this.color == Color.BLACK){
            this.icon = '\u2659';
        } else {
            this.icon = '\u265F';
        }
    }

    @Override
    public boolean isValidMovement(Coordinate origin, Coordinate destination){
        return true;
    }
}
