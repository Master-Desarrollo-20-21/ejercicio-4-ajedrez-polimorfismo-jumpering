package Chess;

import java.util.Objects;

public class Coordinate {

    private final int LIMIT_RANGE = 8;
    protected int x;
    protected int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public String toString(){

        return "x: " + this.x + ", y: " + this.y;
    }

    public int getX(){

        return this.x;
    }

    public int getY(){

        return this.y;
    }

//    public List<Coordinate> coordinatesOnHorizontal(Coordinate coordinate){
//        List<Coordinate> coordinateList = new ArrayList<Coordinate>();
//        if (this.y > coordinate.y){
//            int diference = this.y - coordinate.y;
//            for (int i = 0; i < diference; i++){
//                coordinateList.add(new Coordinate(this.x, this.y - (i+1)));
//            }
//        } else if (this.y < coordinate.y){
//            int diference = coordinate.y - this.y;
//            for (int i = 0; i < diference; i++){
//                coordinateList.add(new Coordinate(this.x, this.y + (i+1)));
//            }
//        }
//        return coordinateList;
//    }
}
