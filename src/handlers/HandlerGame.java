package src.handlers;
import src.players.*;
import src.board.*;
import java.util.*;

public class HandlerGame {
    private int idP1,idP2;
    private Player[] p;
    Scanner scanner = new Scanner(System.in);
    private HandlerPlayers hp; 
    private HandlerPanel h;// = new HandlerPanel();




    public HandlerGame(Player[] players) {
        this.hp = new HandlerPlayers(players);
    }
    public void gameMenu() {
        
        // if(p.okPlayers()){
            gameStart();

        
        // System.out.println(id1+" "+id2);

        // System.out.println("Start game? (y/n)");
        // String op = scanner.nextLine();
        // if(op.equalsIgnoreCase("y")){
        // }
    }

    public void gameStart() {
        boolean tmp =hp.selectPlayers(); //send players[]
        printPanel(tmp);
        h.position();

    }
    public void printPanel(boolean print) {
        if(print){
            h= new HandlerPanel();
        }
    }
}
