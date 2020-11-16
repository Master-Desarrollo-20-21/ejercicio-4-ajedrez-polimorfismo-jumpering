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
        //valid movements for King algorithm: ////(Math.abs(f1-f2)<=1) && (Math.abs(c1-c2) <=1)
        if ((Math.abs(origin.getX() - destination.getX()) <= 1) && (Math.abs(origin.getY() - destination.getY()) <= 1)){
            System.out.println("movimiento permitido");
            return true;
        }
        System.out.println("movimiento NO permitido");
        return false;
    }

    @Override
    public boolean isKing() {
        return true;
    }
}
