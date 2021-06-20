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
            int x = getEntero("Select #row: ");
            int y = getEntero("Select #column: "); 
            boolean op1 = verifyCell(x,y);
            //p.printBoard(x,y,verifyCell(x,y));
            int x1 = getEntero("Move to #row: ");
            int y1 = getEntero("Move to #column: "); 
            //p.printBoard(x1,y1,verifyNewCell(x1,y1));
            boolean op2 = verifyNewCell(x1,y1);
            if(op1 && op2){
                
                p.printBoard(x,y,x1,y1);
                System.out.println("Logrado");
            }else{
                p.printBoard();
            }
            op = getEntero("11 para salir...");
        }
    }

    
    

    public boolean verifyCell(int x,int y) {
        Cell[][] tmp = p.getPanel();
        if(!tmp[x][y].getIsWhite() && tmp[x][y].getOccupied()){
            return true; //not is white && is occupied
        }else{
            return false; //is white && noi is occupied
        }
    }

    public boolean verifyNewCell(int x1,int y1){
        Cell[][] tmp = p.getPanel();
        if(tmp[x1][y1].getIsWhite() && tmp[x1][y1].getOccupied()){
            return false; //is white && is occupied
        }else{
            return true; //not is white && not is occupied
        }
    }
}
