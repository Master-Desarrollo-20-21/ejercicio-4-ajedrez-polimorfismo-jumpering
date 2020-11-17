package Chess;

import java.util.List;

public class Player {

    private Color color;
    private final int MAXIM_SIZE_BOARD = 8;

    public Player(Color color){
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public Coordinate getValidCoordinate(){
        int x, y;
        do {
            String userCoordinate = IO.getInstance().readText("(separado por comas): ");
            String[] originArray = userCoordinate.split(",");
            x = Integer.parseInt(originArray[0]);
            y = Integer.parseInt(originArray[1]);
        } while ( (x < 0 || x > MAXIM_SIZE_BOARD) && (y < 0 || y > MAXIM_SIZE_BOARD));
        return new Coordinate(x,y);
    }

    public void move(Board board) {
        Coordinate origin;
        Coordinate destination;
        do {
            IO.getInstance().printTextWithoutNewLine("Inserte coordenada origen: ");
            origin = this.getValidCoordinate();
            IO.getInstance().printTextWithoutNewLine("Inserte coordenada destino: ");
            destination = this.getValidCoordinate();
            if (this.piecesBetweenCoordinates(board, origin, destination)
                    && this.proposedMovementIsValid(board, origin, destination)){
                if (board.isPieceOnCoordinate(destination) && board.getPiece(destination).isKing()) {
                    board.setDeadKing(true);
                    //board.terminate?
                }
                if ( board.isPieceOnCoordinate(destination) ){
                    board.getPiece(destination).kill();
                }
                board.setCoordinateOnPiece(origin, destination);
            }
        } while (proposedMovementIsValid(board, origin, destination));
    }

    private boolean piecesBetweenCoordinates(Board board, Coordinate origin, Coordinate destination){
        List<Coordinate> coordinateList = origin.betweenCoordinatesOnHorizontal(destination);
        coordinateList.addAll(origin.betweenCoordinatesOnVertical(destination));
        coordinateList.addAll(origin.betweenCoordinatesOnDiagonal(destination));
        for (Coordinate coordinate : coordinateList){
            if ( board.isPieceOnCoordinate( coordinate ) ){
                return false;
            }
        }
        return true;
    }

    private boolean proposedMovementIsValid(Board board, Coordinate origin, Coordinate destination){
        if (board.isPieceOnCoordinate(origin) && board.getPiece(origin).getColor() == this.color
                && board.getPiece(origin).isValidMovement(board, origin, destination)
                && !board.isPieceOnCoordinate(destination)) {
            return true;
        }
        if (board.isPieceOnCoordinate(origin) && board.getPiece(origin).getColor() == this.color
                && board.getPiece(origin).isValidMovement(board, origin, destination)
                && board.isPieceOnCoordinate(destination) && board.getPiece(destination).getColor() != this.color) {
            return true;
        }
        return false;
    }
}