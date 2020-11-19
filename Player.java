package Chess;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {

    private Color color;
    private final int MAXIM_SIZE_BOARD = 8;

    public Player(Color color){
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    private boolean isValidPattern(){


        return false;
    }

    public Coordinate getValidCoordinate(){
        Pattern PATTERN = Pattern.compile( "^[0-7](,[0-7])*$");
        Matcher match;
        String userInput;
        do {
            userInput = Mastermind.IO.getInstance().readText("(0-7,0-7 formato) ");
            match = PATTERN.matcher(userInput);
        }while (!match.find());
        int x, y;
        String[] originArray = userInput.split(",");
        x = Integer.parseInt(originArray[0]);
        y = Integer.parseInt(originArray[1]);
        return new Coordinate(x, y);
    }

    public void move(Board board) {
        Coordinate origin;
        Coordinate destination;
        do {
            IO.getInstance().printTextWithoutNewLine("Coordenada origen: ");
            origin = this.getValidCoordinate();
            IO.getInstance().printTextWithoutNewLine("Coordenada destino: ");
            destination = this.getValidCoordinate();
        } while (!proposedMovementIsValid(board, origin, destination)
                || piecesBetweenCoordinates(board, origin, destination));
        if (board.isPieceOnCoordinate(destination) && board.getPiece(destination).isKing()) {
            board.setDeadKing(true);
            //board.terminate?
        }
        if ( board.isPieceOnCoordinate(destination) ){
            board.getPiece(destination).kill();
        }
        board.setCoordinateOnPiece(origin, destination);
    }

    private boolean piecesBetweenCoordinates(Board board, Coordinate origin, Coordinate destination){
        List<Coordinate> coordinateList = origin.betweenCoordinatesOnHorizontal(destination);
        coordinateList.addAll(origin.betweenCoordinatesOnVertical(destination));
        coordinateList.addAll(origin.betweenCoordinatesOnDiagonal(destination));
        for (Coordinate coordinate : coordinateList){
            if ( board.isPieceOnCoordinate( coordinate ) ){
                System.out.println("piezas entre coordenadas");
                return true;
            }
        }
        System.out.println("No hay piezas entre coordenadas");
        return false;
    }

    private boolean proposedMovementIsValid(Board board, Coordinate origin, Coordinate destination){
        if (board.isPieceOnCoordinate(origin) && board.getPiece(origin).getColor() == this.color
                && board.getPiece(origin).isValidMovement(board, origin, destination)
                && !board.isPieceOnCoordinate(destination)) {
            System.out.println("propuesto true");
            return true;
        }
        if (board.isPieceOnCoordinate(origin) && board.getPiece(origin).getColor() == this.color
                && board.getPiece(origin).isValidMovement(board, origin, destination)
                && board.isPieceOnCoordinate(destination) && board.getPiece(destination).getColor() != this.color) {
            System.out.println("propuesto true");
            return true;
        }
        System.out.println("propuesto false");
        return false;
    }
}