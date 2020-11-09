package Chess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
    private final Scanner scanner = new Scanner(System.in);
    private String title;
    private static IO INSTANCE;

    public static IO getInstance() {
        if (INSTANCE == null){
            INSTANCE = new IO();
        }
        return INSTANCE;
    }

    private IO(){

    }

    public int readInt(String title){
        this.title = title;
        boolean ok = false;
        int result = 0;
        do {
            try{
                System.out.print( this.title );
                result = scanner.nextInt();
                scanner.nextLine(); //para acabar de leer hasta el salto de linea
                ok = true;
            }catch(InputMismatchException ex){
                System.out.println("error, integer only");
                scanner.next();
            }
        } while (!ok);
        return result;
    }

    public String readText(String title){
        this.title = title;
        boolean ok = false;
        String result = null;
        do{
            try{
                System.out.print( this.title );
                result = scanner.nextLine();
                ok = true;
            }catch(InputMismatchException ex){
                System.out.println("error");
                scanner.next();
            }
        }while(!ok);
    return result;
    }

    public void printText(Object object){
        System.out.println(object);
    }

    public void printTextWithoutNewLine(Object object){
        System.out.print(object);
    }
}