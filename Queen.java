package Chess;

public class Queen extends Piece{
    public Queen(Color color) {
        super(color);
        if (this.color == Color.BLACK){
            this.icon = '\u2655';
        } else {
            this.icon = '\u265B';
        }
    }

    @Override
    public boolean isValidMovement(Board board, Coordinate origin, Coordinate destination) {
        if (origin.getRow() == destination.getRow() || destination.getColumn() == destination.getColumn() || ( Math.abs(origin.getRow()-destination.getRow()) == Math.abs(origin.getColumn()-destination.getColumn())) ){
            return true;
        }
        return false;
    }

    @Override
    public boolean isKing() {
        return false;
    }
}
