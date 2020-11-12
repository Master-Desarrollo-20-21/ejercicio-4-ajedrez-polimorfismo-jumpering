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
            String userCoordinate = IO.getInstance().readText("Coordenada (separado por comas): ");
            String[] originArray = userCoordinate.split(",");
            x = Integer.parseInt(originArray[0]);
            y = Integer.parseInt(originArray[1]);
        } while ( (x < 0 || x > MAXIM_SIZE_BOARD) && (y < 0 || y > MAXIM_SIZE_BOARD));
        return new Coordinate(x,y);
    }

    public void move(Board board){
        Coordinate origin = this.getValidCoordinate();
        Coordinate destination = this.getValidCoordinate();
//        List<Coordinate> coordinatesInHorizontal = origin.coordinatesOnHorizontal(destination);
//        for (Coordinate coordinate : coordinatesInHorizontal) {
//            System.out.println("coordenadas: " + coordinate);
//            System.out.println("piezas en coordenada: " + board.isPieceOnCoordinate(coordinate));
//            System.out.println("piezas en coordenadas mismo color: " + board.isPieceOnCoordinateSameColor(coordinate, this.color));
//
//        }
        if (board.isPieceOnCoordinate(origin)
                && board.getPiece(origin).getColor() == this.getColor()) {
            Piece piece = board.getPiece(origin);

            if (piece.isValidMovement(origin, destination)) {
                if (board.isPieceOnCoordinate(destination)) {
                    board.getPiece(destination).kill();
                    if (board.getPiece(destination).isKing()) {
                        board.setDeadKing(true);
                    }
                }
                board.setCoordinateOnPiece(origin, destination);
            }
        }
    }

}
