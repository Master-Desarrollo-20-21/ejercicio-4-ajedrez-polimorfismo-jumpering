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
        if ( origin.getY() == destination.getY() && origin.getX() == destination.getX() + 1 || origin.getX() == destination.getX() - 1) {
            //ahora si hay una delante no puede mover
//            if (board.isPieceOnCoordinate(destination)
//                    && board.getPiece(destination).getColor() != color
//                    && board.getCountTurn() == 1) {
//                System.out.println("movimiento permitido");
//                return false;
//            }
            //ahora si no hay nadie delante puede mover
//            if (!board.isPieceOnCoordinate(destination)) {
//                System.out.println("movimiento permitido");
//                return true;
//            }
            //si tiran en diagonal y hay alguien (mata)
//            if (origin.getY() == destination.getY() && origin.getX() == destination.getX() + 1 || origin.getX() == destination.getX() - 1) {
//                return true;
//            }
            System.out.println("movimiento permitido");
            firstMovement = false;
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
