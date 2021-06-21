package src.handlers;
import src.board.*;
import src.players.*;
import java.util.*;



public class HandlerPanel {

    Scanner scanner = new Scanner(System.in);
    Panel p = new Panel();
    public HandlerPanel() {
        p.printBoard();

    }
    
    private int getEntero(String message){
        System.out.println(message);
        int tmp = scanner.nextInt();
        scanner.nextLine();
        return tmp;
    }



    public boolean position(boolean isPlayer1) {
        boolean contin = true; //i can change it for exit the game
        boolean tmp = true;
        do{

            System.out.println("\n\n");
            //initial position
            int x = getEntero("Select #row: ");
            int y = getEntero("Select #column: "); 
            boolean op1 = verifyCell(x,y);
            System.out.println(op1);
            
            //end position
            int x1 = getEntero("Move to #row: ");
            int y1 = getEntero("Move to #column: "); 
            boolean op2 = verifyNewCell(x1,y1);
            System.out.println(op1);
            

            if(op1==true && op2==true){
                if(canMove(x,y,x1,y1,isPlayer1)){

                    p.printBoard(x,y,x1,y1);
                    System.out.println("Successful..");
                    tmp = false;
                    //tmp=true; //if draw is ok
                    
                }

            }else{
                p.printBoard();
                System.out.println("Try again...");
            }
        }while(tmp);
        return contin;
    }




    public boolean verifyCell(int x,int y) {
        Cell[][] tmp = p.getPanel();
        if(tmp[x][y].getIsWhite()==false && tmp[x][y].getOccupied()==true){
            return true; //not is white && is occupied
        }else{
            return false; //is white && noi is occupied
        }
    }




    public boolean verifyNewCell(int x1,int y1){
        Cell[][] tmp = p.getPanel();
        if(tmp[x1][y1].getIsWhite()==false && tmp[x1][y1].getOccupied()==false){
            return true; //not is white && is occupied
        }else{
            return false; //is white && is occupied
        }
    }

    

    public boolean canMove(int x, int y, int x1,int y1,boolean isPlayer1){ //player1 is true (yellow) else green for p2
        Cell[][] tmp = p.getPanel();
        int l1 = Math.abs(x-x1);
        int l2 = Math.abs(y-y1);
        System.out.println("l1: "+l1);
        System.out.println("l2: "+l2);
        if(l1==1 && l2==1 && isPlayer1==tmp[x][y].getPlayer1()){ //comparamos si la longitud es 1 y si el jugador == jugador de la ficha
            return true;
        }else if(l1==2 && l2==2 && isPlayer1==tmp[x][y].getPlayer1()){
            int posx = (x+x1)/2;
            int posy = (y+y1)/2;
            deleteCoin(posx,posy);
            return true;
        
        }else{
            System.out.println("you can't move that coin");
            System.out.println("Try again.....");
            return false;
        }
    }

    public void deleteCoin(int posx, int posy){
        Cell[][] tmp = p.getPanel();
        if(tmp[posx][posy].getOccupied() && tmp[posx][posy].getIsWhite()==false){
            tmp[posx][posy].setOccupied(false);
        }
    }



}
