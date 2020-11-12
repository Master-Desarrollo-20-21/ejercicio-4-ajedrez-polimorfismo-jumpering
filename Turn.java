package Chess;

public class Turn {
    private Player playerBlack;
    private Player playerWhite;
    private Player current;
    private int turnCount;

    public Turn(){
        playerBlack = new Player(Color.BLACK);
        playerWhite = new Player(Color.WHITE);
        current = playerWhite;
    }

    public Player next(){
        turnCount++;
        if (this.current == playerBlack){
            this.current = playerWhite;
            return playerWhite;
        }
        this.current = playerBlack;
        return playerBlack;
    }

    public Player getCurrent(){

        return this.current;
    }

    public int getTurnCount(){
        return this.turnCount;
    }
}
