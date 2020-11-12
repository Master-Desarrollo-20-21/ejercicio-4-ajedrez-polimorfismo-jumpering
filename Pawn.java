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
        //valid movements for Rook algorithm: ////salida 1 o 2, luego solo 1, y matar diagonal 1
        if (origin.getY() == destination.getY()+1 || origin.getY() == destination.getY()-1){
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
