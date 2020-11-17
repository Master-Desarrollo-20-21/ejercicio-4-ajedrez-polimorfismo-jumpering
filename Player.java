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
        //vale, ara miraré si hay piezas en medio, HORIZONTALES
        List<Coordinate> coordinateListHorizontal = origin.betweenCoordinatesOnHorizontal(destination);
        for ( Coordinate coordinate : coordinateListHorizontal ) {
            if ( board.isPieceOnCoordinate( coordinate ) ){
                System.out.println("pieza en medio HORIZONTAL");
                return false;
            }
        }
        //vale, ara miraré si hay piezas en medio, VERTICALES
        List<Coordinate> coordinateListVertical = origin.betweenCoordinatesOnVertical(destination);
        for ( Coordinate coordinate : coordinateListVertical ) {
            if ( board.isPieceOnCoordinate( coordinate ) ){
                System.out.println("pieza en medio VERTICAL");
                return false;
            }
        }
        //vale, ara miraré si hay piezas en medio, DIAGONALES
        List<Coordinate> coordinateListDiagonal = origin.betweenCoordinatesOnDiagonal(destination);
        for ( Coordinate coordinate : coordinateListDiagonal ) {
            if ( board.isPieceOnCoordinate( coordinate ) ){
                System.out.println("pieza en medio DIAGONAL");
                return false;
            }
        }
        return true;
    }

    private boolean proposedMovementIsValid(Board board, Coordinate origin, Coordinate destination){
        //si origen = yo de mi color + movimiento permitido + destino = nadie
        if (board.isPieceOnCoordinate(origin) && board.getPiece(origin).getColor() == this.color
                && board.getPiece(origin).isValidMovement(board, origin, destination)
                && !board.isPieceOnCoordinate(destination)) {
            System.out.println("origen YO, mov OK, dest vacio");
            return true;
        }
        //si origen = yo de mi color + movimiento permitido + destino = alguien del distinto color
        if (board.isPieceOnCoordinate(origin) && board.getPiece(origin).getColor() == this.color
                && board.getPiece(origin).isValidMovement(board, origin, destination)
                && board.isPieceOnCoordinate(destination) && board.getPiece(destination).getColor() != this.color) {
            System.out.println("origen YO, mov OK, dest PIEZA DISTINTO COLOR");
            return true;
        }
        return false;
    }
}