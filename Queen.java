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
        //valid movements for Queen algorithm: ////(f1==f2) || (c1==c2) || (Math.abs(f1-f2) == Math.abs(c1-c2))
        if (origin.getX() == destination.getX() || destination.getY() == destination.getY() || ( Math.abs(origin.getX()-destination.getX()) == Math.abs(origin.getY()-destination.getY())) ){
            System.out.println("movimiento permitido");
            return true;
        }
        System.out.println("movimiento NO permitido");
        return false;
    }

    @Override
    public boolean isKing() {
        return false;
    }
}
