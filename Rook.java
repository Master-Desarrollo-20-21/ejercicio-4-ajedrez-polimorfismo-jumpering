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
    public boolean isValidMovement(Coordinate origin, Coordinate destination) {
        //valid movements for Rook algorithm: ////(f1==f2) || (c1==c2)
        if (origin.getX() == destination.getX() || origin.getY() == destination.getY()){
            System.out.println("movimiento permitido");
            return true;
        } else {
            System.out.println("movimiento NO permitido");
            return false;
        }
    }

    @Override
    public boolean isKing() {
        return false;
    }
}
