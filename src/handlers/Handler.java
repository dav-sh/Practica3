package src.handlers;
import src.board.*;
import src.players.*;
import java.util.*;



public class Handler {
    Scanner scanner = new Scanner(System.in);
    Panel p = new Panel();
    public Handler() {
        p.printBoard();

    }
    
    public int getEntero(String message){
        System.out.println(message);
        int tmp = scanner.nextInt();
        scanner.nextLine();
        return tmp;
    }



    public void position() {

        int op = 12;
        while(op!=11){
            System.out.println("\n\n");
            int x = getEntero("Enter x: ");
            int y = getEntero("Enter y: "); 
            p.printBoard(x,y,true);
            op = getEntero("11 para salir...");
        }
    }
}
