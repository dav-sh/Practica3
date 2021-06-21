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
                    //aqui tengo q verificar si puede comer mas o no con el deleteCoin()

                    if(coinsP2()==0 || coinsP1()==0){
                        contin = false;
                    }
                    p.printBoard(x,y,x1,y1);
                    System.out.println("Successful..");
                    tmp = false;
                    //tmp=true; //if draw is ok
                    
                }

            }else{
                p.printBoard();
                if(isPlayer1){
                    System.out.println("Turn Player : 1 (yellow)");
    
                }else{
                    System.out.println("Turn Player : 2 (green)");
                }
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
            if(deleteCoin(posx,posy)){
                return true;
            }else{
                System.out.println("you can't move that coin");
                System.out.println("Try again.....");
                return false;
            }
        
        }else{
            System.out.println("you can't move that coin");
            System.out.println("Try again.....");
            return false;
        }
    }

    public boolean deleteCoin(int posx, int posy){
        Cell[][] tmp = p.getPanel();
        if(tmp[posx][posy].getOccupied() && tmp[posx][posy].getIsWhite()==false){
            tmp[posx][posy].setOccupied(false);
            return true;

        }else{
            return false;
        }
    }

    public int coinsP2(){
        int countG =0;
        Cell[][] tmp = p.getPanel();
        for(int i = 0; i < tmp.length;i++){
            for(int j = 0; j<tmp.length;j++){
                if(tmp[i][j].getOccupied() && tmp[i][j].getPlayer1()==false){ //verify are green
                    countG++;
                }
            }

        }
        System.out.println("Greens coins: " + countG);
        return countG;
    }
    public int coinsP1(){
        int countG =0;
        Cell[][] tmp = p.getPanel();
        for(int i = 0; i < tmp.length;i++){
            for(int j = 0; j<tmp.length;j++){
                if(tmp[i][j].getOccupied() && tmp[i][j].getPlayer1()==true){ //verify are yellow
                    countG++;
                }
            }

        }
        System.out.println("Yellow coins: " + countG);
        return countG;
    }



}
