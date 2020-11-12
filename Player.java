package Chess;

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
        do {
            IO.getInstance().printTextWithoutNewLine("Inserte coordenada origen: ");
            Coordinate origin = this.getValidCoordinate();
            IO.getInstance().printTextWithoutNewLine("Inserte coordenada destino: ");
            Coordinate destination = this.getValidCoordinate();
            //si origen = yo de mi color + movimiento permitido + destino = nadie
            if (board.isPieceOnCoordinate(origin) && board.getPiece(origin).getColor() == this.color
                    && board.getPiece(origin).isValidMovement(board, origin, destination)
                    && !board.isPieceOnCoordinate(destination)) {
                board.setCoordinateOnPiece(origin, destination);
                validMove = true;
            }
            //si origen = yo de mi color + movimiento permitido + destino = alguien del distinto color
            if (board.isPieceOnCoordinate(origin) && board.getPiece(origin).getColor() == this.color
                    && board.getPiece(origin).isValidMovement(board, origin, destination)
                    && board.isPieceOnCoordinate(destination) && board.getPiece(destination).getColor() != this.color) {
                if (board.getPiece(destination).isKing()) {
                    validMove = true;
                    board.setDeadKing(true);
                    //board.terminate?
                }
                board.getPiece(destination).kill();
                board.setCoordinateOnPiece(origin, destination);
                validMove = true;
            }
        } while (!validMove);
    }
}
