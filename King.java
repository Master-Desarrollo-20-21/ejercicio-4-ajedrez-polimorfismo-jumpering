package Chess;

public class King extends Piece{
    public King(Color color) {
        super(color);
        if (this.color == Color.BLACK) {
            this.icon = '\u2654';
        } else {
            this.icon = '\u265A';
        }
    }

    @Override
    public boolean isValidMovement(Board board, Coordinate origin, Coordinate destination) {
        if ((Math.abs(origin.getRow() - destination.getRow()) <= 1) && (Math.abs(origin.getColumn() - destination.getColumn()) <= 1)){
            return true;
        }
        return false;
    }

    @Override
    public boolean isKing() {
        return true;
    }
}
