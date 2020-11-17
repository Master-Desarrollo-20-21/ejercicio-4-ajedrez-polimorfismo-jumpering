package Chess;

import java.util.HashMap;

public class Board {
    private HashMap<Coordinate, Piece> pieces;
    private boolean deadKing;
    private int countTurn;
    public Board(){
        deadKing = false;
        countTurn = 0;
        pieces = new HashMap<Coordinate, Piece>();
        pieces.put(new Coordinate(0,1), new Knight(Color.BLACK));
        pieces.put(new Coordinate(0,6), new Knight(Color.BLACK));
        pieces.put(new Coordinate(7,1), new Knight(Color.WHITE));
        pieces.put(new Coordinate(7,6), new Knight(Color.WHITE));
        for (int i = 0; i < 8; i++){
            pieces.put(new Coordinate(1,i), new Pawn(Color.BLACK));
            pieces.put(new Coordinate(6,i), new Pawn(Color.WHITE));
        }
        pieces.put(new Coordinate(0,0), new Rook(Color.BLACK));
        pieces.put(new Coordinate(0,7), new Rook(Color.BLACK));

        pieces.put(new Coordinate(7,0), new Rook(Color.WHITE));
        pieces.put(new Coordinate(7,7), new Rook(Color.WHITE));

        pieces.put(new Coordinate(0,3), new Queen(Color.BLACK));
        pieces.put(new Coordinate(7,3), new Queen(Color.WHITE));

        pieces.put(new Coordinate(0,2), new Bishop(Color.BLACK));
        pieces.put(new Coordinate(0,5), new Bishop(Color.BLACK));

        pieces.put(new Coordinate(7,2), new Bishop(Color.WHITE));
        pieces.put(new Coordinate(7,5), new Bishop(Color.WHITE));

        pieces.put(new Coordinate(0,4), new King(Color.BLACK));
        pieces.put(new Coordinate(7,4), new King(Color.WHITE));
    }

    public void show() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                if (pieces.containsKey(coordinate) && pieces.get(coordinate).isAlive()) {
                    System.out.print(" ");
                    System.out.print(pieces.get(coordinate).show());
                } else {
                    System.out.print( " # ");
                }
                //System.out.print("_");
            }
            System.out.println();
        }
    }

    public Piece getPiece(Coordinate coordinate){

        return pieces.get(coordinate);
    }

    public boolean isPieceOnCoordinate(Coordinate coordinate){

        return pieces.containsKey(coordinate);
    }

    public boolean isPieceOnCoordinateSameColor(Coordinate coordinate, Color color){
        if (this.isPieceOnCoordinate(coordinate)){
            if (this.pieces.get(coordinate).getColor() == color){
                return true;
            }
        }
        return false;
    }

    public void setCoordinateOnPiece(Coordinate origin, Coordinate destination){
        if (pieces.containsKey(origin)){
            Piece pieceTemp = pieces.get(origin);
            pieces.remove(origin);
            pieces.put(destination,pieceTemp);
        }
    }

    public boolean isDeadKing(){

        return this.deadKing;
    }

    public void setDeadKing(boolean deadKing){

        this.deadKing = deadKing;
    }

    public void incrementCountTurn(){
        this.countTurn++;
    }

    public int getCountTurn(){
        return this.countTurn;
    }
}
