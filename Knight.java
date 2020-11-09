package Chess;

public class Knight extends Piece{

    public Knight(Color color){
        super(color);
        if (this.color == Color.BLACK){
            this.icon = '\u2658';
        } else {
            this.icon = '\u265E';
        }
    }

    @Override
    public boolean isValidMovement(Coordinate origin, Coordinate destination) {
        //valid movements for Knight algorithm: ////(f1-f2)*(f1-f2) + (c1-c2)*(c1-c2) == 5
        if ((origin.getX()-destination.getX())*(origin.getX()-destination.getX())
                + (origin.getY()-destination.getY())*(origin.getY()-destination.getY()) == 5){
            System.out.println("movimiento permitido");
            return true;
        } else {
            System.out.println("movimiento NO permitido");
            return false;
        }
    }
}
