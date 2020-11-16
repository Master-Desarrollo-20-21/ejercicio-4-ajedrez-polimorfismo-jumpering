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
        boolean validMove = false;
        boolean freeWay = true;
        do {
            IO.getInstance().printTextWithoutNewLine("Inserte coordenada origen: ");
            Coordinate origin = this.getValidCoordinate();
            IO.getInstance().printTextWithoutNewLine("Inserte coordenada destino: ");
            Coordinate destination = this.getValidCoordinate();
            //si origen = yo de mi color + movimiento permitido + destino = nadie
            if (board.isPieceOnCoordinate(origin) && board.getPiece(origin).getColor() == this.color
                    && board.getPiece(origin).isValidMovement(board, origin, destination)
                    && !board.isPieceOnCoordinate(destination)) {
                System.out.println("origen YO, mov OK, dest vacio");
                validMove = true;
            }
            //si origen = yo de mi color + movimiento permitido + destino = alguien del distinto color
            if (board.isPieceOnCoordinate(origin) && board.getPiece(origin).getColor() == this.color
                    && board.getPiece(origin).isValidMovement(board, origin, destination)
                    && board.isPieceOnCoordinate(destination) && board.getPiece(destination).getColor() != this.color) {
                System.out.println("origen YO, mov OK, dest PIEZA DISTINTO COLOR");
                validMove = true;
            }

            //si origen = yo de mi color + movimiento permitido + destino = alguien del distinto color
            //vale, ara miraré si hay piezas en medio, HORIZONTALES
            List<Coordinate> coordinateListHorizontal = origin.betweenCoordinatesOnHorizontal(destination);
            for ( Coordinate coordinate : coordinateListHorizontal ) {
                if ( board.isPieceOnCoordinate( coordinate ) ){
                    System.out.println("pieza en medio HORIZONTAL");
                    freeWay = false;
                }
            }
            //vale, ara miraré si hay piezas en medio, VERTICALES
            List<Coordinate> coordinateListVertical = origin.betweenCoordinatesOnVertical(destination);
            for ( Coordinate coordinate : coordinateListVertical ) {
                if ( board.isPieceOnCoordinate( coordinate ) ){
                    System.out.println("pieza en medio VERTICAL");
                    freeWay = false;
                }
            }
            //vale, ara miraré si hay piezas en medio, DIAGONALES
            List<Coordinate> coordinateListDiagonal = origin.betweenCoordinatesOnDiagonal(destination);
            for ( Coordinate coordinate : coordinateListDiagonal ) {
                if ( board.isPieceOnCoordinate( coordinate ) ){
                    System.out.println("pieza en medio DIAGONAL");
                    freeWay = false;
                }
            }
            if (freeWay && validMove){
                System.out.println("freeWay y validMove");

                //OJO ESTO TIENE QUE ESTAR PORQUE MATA AL REY, PERO DA UN OUTBOUND EXCEPTION
                if (board.isPieceOnCoordinate(destination) && board.getPiece(destination).isKing()) {
                    System.out.println("destino es rey, marco en board que está muerto y lo mato");
                    board.setDeadKing(true);
                    System.out.println("EXIT");
                    //board.terminate?
                }
                if ( board.isPieceOnCoordinate(destination) ){
                    board.getPiece(destination).kill();
                }
                System.out.println("MUEVO!!!");
                board.setCoordinateOnPiece(origin, destination);
            } else {
                System.out.println("Movimiento NO permitido");
            }
        } while (!validMove);
    }
}