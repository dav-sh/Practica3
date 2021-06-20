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
            int x = getEntero("Enter #row: ");
            int y = getEntero("Enter #column: "); 
            p.printBoard(x,y,verifyIsWhite(x,y));
            op = getEntero("11 para salir...");
        }
    }

    public boolean verifyIsWhite(int x,int y) {
        Cell[][] tmp = p.getPanel();
        if(tmp[x][y].getIsWhite()){
            return false;
        }else{
            return true;
        }

    }
}
