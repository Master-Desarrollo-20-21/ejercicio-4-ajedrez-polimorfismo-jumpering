package Chess;

public class Rook extends Piece{


    public Rook(Color color) {
        super(color);
        if (this.color == Color.BLACK){
            this.icon = '\u2656';
        } else {
            this.icon = '\u265C';
        }
    }

    @Override
    public boolean isValidMovement(Board board, Coordinate origin, Coordinate destination) {
        if (origin.getRow() == destination.getRow() || origin.getColumn() == destination.getColumn()){
            return true;
        }
        return false;
    }

    @Override
    public boolean isKing() {
        return false;
    }
}
