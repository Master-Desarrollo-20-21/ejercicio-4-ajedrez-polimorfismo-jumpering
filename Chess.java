package Chess;

public class Chess {

    private Board board;
    private Turn turn;

    public Chess(){
        board = new Board();
        turn = new Turn();
    }

    public void play(){
        do{
            board.show();
            IO.getInstance().printText("Turno de " + turn.getCurrent().getColor());
            int originX = IO.getInstance().readInt("origen X: ");
            int originY = IO.getInstance().readInt("origen Y: ");
            int destinationX = IO.getInstance().readInt("destino X: ");
            int destinationY = IO.getInstance().readInt("destino Y: ");
            Coordinate userOrigin = new Coordinate(originX,originY);
            Coordinate userDestination = new Coordinate(destinationX,destinationY);
            if (board.isPieceOnCordinate(userOrigin) && board.getPiece(userOrigin).getColor() == turn.getCurrentColor()){
                Piece piece = board.getPiece(userOrigin);
                piece.isValidMovement(userOrigin, userDestination);
                if (board.isPieceOnCordinate(userDestination)){
                    board.getPiece(userDestination).kill();
                    board.setCoordinateOnPiece(userOrigin,userDestination);
                } else {
                    board.setCoordinateOnPiece(userOrigin,userDestination);
                }
            }
            turn.next();
        }while(true);
        //}while(board.getBlackKingAliveState() || board.getWhiteKingAliveState());
    }

    public static void main(String[] args) {
        new Chess().play();
    }
}
