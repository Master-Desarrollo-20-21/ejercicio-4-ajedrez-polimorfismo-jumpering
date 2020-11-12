package Chess;

public class Bishop extends Piece{
    public Bishop(Color color) {
        super(color);
        if (this.color == Color.BLACK){
            this.icon = '\u2657';
        } else {
            this.icon = '\u265D';
        }
    }

    @Override
    public boolean isValidMovement(Board board, Coordinate origin, Coordinate destination) {
        //valid movements for Bishop algorithm: ////Math.abs(f1 – f2) == Math.abs(c1 – c2)
        if (Math.abs(origin.getX() - destination.getX()) == Math.abs(origin.getY() - destination.getY()) ){
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
