package Chess;

public class Chess {
    private Board board;
    private Turn turn;

    public Chess(){
        board = new Board();
        turn = new Turn();
    }

    public void play(){
        //TODO: LIMITES FUERA DEL TABLERO + doble do en this.play() + acabar partida + peón 2 movimientos y matar diagonal
        do {
            do {
                board.show();
                IO.getInstance().printText("Turno de " + turn.getCurrent().getColor());
                turn.getCurrent().move(board);
                turn.next();
            }while(!board.isDeadKing());
        }while(this.isResumed());
    }

    private boolean isResumed(){
        String answer;
        do{
            answer = IO.getInstance().readText("¿Reiniar la partida? (s/n)");
        } while( !answer.equals("s") && !answer.equals("n") );
        return answer.equals("s");
    }

    public static void main(String[] args) {
        new Chess().play();
    }
}
