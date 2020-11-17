package Chess;

public class Knight extends Piece{

    public Knight(Color color){
        super(color);
        if (this.color == Color.BLACK){
            this.icon = '\u2658';
        } else {
            this.icon = '\u265E';
        }
    }

    @Override
    public boolean isValidMovement(Board board, Coordinate origin, Coordinate destination) {
        if ((origin.getRow()-destination.getRow())*(origin.getRow()-destination.getRow())
                + (origin.getColumn()-destination.getColumn())*(origin.getColumn()-destination.getColumn()) == 5){
            return true;
        }
        return false;
    }

    @Override
    public boolean isKing() {
        return false;
    }

}
