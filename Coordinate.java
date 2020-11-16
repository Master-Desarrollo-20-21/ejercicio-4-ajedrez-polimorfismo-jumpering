package Chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coordinate {

    private final int LIMIT_RANGE = 8;
    protected int x;
    protected int y;

    public Coordinate(int x, int y) {
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

    public String toString() {

        return "x: " + this.x + ", y: " + this.y;
    }

    public int getX() {

        return this.x;
    }

    public int getY() {

        return this.y;
    }

    public List<Coordinate> betweenCoordinatesOnHorizontal(Coordinate coordinate) {
        List<Coordinate> coordinateList = new ArrayList<Coordinate>();
        if (this.y < coordinate.y && this.x == coordinate.x) {
            System.out.println("Traza Horizontal origen más pequeño");
            int diference = this.y - coordinate.y;
            diference = diference - 1;//esto me dice quantas hay en medio,
            for (int i = 0; i < diference; i++) {
                coordinateList.add(new Coordinate(this.x, this.y + (i + 1)));
            }
        } else if (this.y > coordinate.y && this.x == coordinate.x) {
            System.out.println("Traza Horizontal origen más grande");
            int diference = coordinate.y - this.y;
            diference = diference - 1;//esto me dice quantas hay en medio,
            for (int i = 0; i < diference; i++) {
                coordinateList.add(new Coordinate(this.x, this.y - (i + 1)));
            }
        }
        return coordinateList;
    }


    public List<Coordinate> betweenCoordinatesOnVertical(Coordinate coordinate) {
        List<Coordinate> coordinateList = new ArrayList<Coordinate>();
        if (this.x < coordinate.x && this.y == coordinate.y) {
            System.out.println("Traza Verticales origen más pequeño");
            int diference = this.x - coordinate.x;
            diference = diference - 1;//esto me dice quantas hay en medio,
            for (int i = 0; i < diference; i++) {
                coordinateList.add(new Coordinate(this.x + (i + 1), this.y));
            }
        } else if (this.x > coordinate.x && this.y == coordinate.y) {
            System.out.println("Traza Verticales origen más grande");
            int diference = coordinate.x - this.x;
            diference = diference - 1;//esto me dice quantas coordenadas hay en medio,
            for (int i = 0; i < diference; i++) {
                coordinateList.add(new Coordinate(this.x - (i + 1), this.y));
            }
        }
        return coordinateList;
    }


    public List<Coordinate> betweenCoordinatesOnDiagonal(Coordinate coordinate) {
        List<Coordinate> coordinateList = new ArrayList<Coordinate>();
        int diference = 0;
        if (this.x < coordinate.x && this.x + this.y == coordinate.x + coordinate.y) {
            System.out.println("1");
            diference = coordinate.x - this.x;
            diference = diference - 1;//esto me dice quantas hay en medio,
            for (int i = 0; i < diference; i++) {
                coordinateList.add(new Coordinate(this.x + (i + 1), this.y - (i + 1)));
            }
        }

        if (this.x > coordinate.x && this.x + this.y == coordinate.x + coordinate.y) {
            System.out.println("2");
            diference = this.x - coordinate.x;
            diference = diference - 1;//esto me dice quantas hay en medio,
            for (int i = 0; i < diference; i++) {
                coordinateList.add(new Coordinate(this.x - (i + 1), this.y + (i + 1)));
            }
        }


        if ( this.x > coordinate.x && this.y - this.x == coordinate.y - coordinate.x ) {
            System.out.println("3");
            diference = this.x - coordinate.x;
            diference = diference - 1;//esto me dice quantas hay en medio,
            for (int i = 0; i < diference; i++) {
                coordinateList.add(new Coordinate(this.x - (i + 1), this.y - (i + 1)));
            }
        }

        if ( this.x < coordinate.x && this.y - this.x == coordinate.y - coordinate.x ) {
            System.out.println("4");
            diference = coordinate.x - this.x;
            diference = diference - 1;//esto me dice quantas hay en medio,
            for (int i = 0; i < diference; i++) {
                coordinateList.add(new Coordinate(this.x + (i + 1), this.y + (i + 1)));
            }
        }

        for (Coordinate coordinatePrint : coordinateList) {
            System.out.println("coordenadas en medio" + coordinatePrint.toString());
        }
        return coordinateList;
    }
}
