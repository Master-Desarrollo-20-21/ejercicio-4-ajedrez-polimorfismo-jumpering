package Chess;

public class Pawn extends Piece {

    private boolean firstMovement = true;

    public Pawn(Color color) {
        super(color);
        if (this.color == Color.BLACK) {
            this.icon = '\u2659';
        } else {
            this.icon = '\u265F';
        }
    }

    @Override
    public boolean isValidMovement(Board board, Coordinate origin, Coordinate destination) {
        //valid movements for Rook algorithm: ////salida 1 o 2, luego solo 1, y matar diagonal 1
        //si solo se mueve adelante OJO + y - direcciones
        //if ( origin.getY() == destination.getY() && origin.getX() == destination.getX() + 1 || origin.getX() == destination.getX() - 1) {
        if (origin.getY() == destination.getY()) {
            System.out.println("movimiento permitido");
            firstMovement = false;
            return true;
        }

        //PERO SI PEÓN TIENE ALGUIEN EN DESTINO....NO PUEDE MATAR, COMO LAS OTRAS
        //si tiran en diagonal y hay alguien (mata)
//        if ( origin.getX() == destination.getX() + 1  && origin.getY() == destination.getY() + 1 || origin.getY() == destination.getY() - 1) {
//            return true;
//        }
        System.out.println("movimiento NO permitido");
        return false;
    }


    @Override
    public boolean isKing() {
        return false;
    }
}
