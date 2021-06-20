package handlers;
import src.players.*;
import java.util.*;

public class HandlerGame {
    private int idP1,idP2;
    private Player[] p;
    Scanner scanner = new Scanner(System.in);


    public HandlerGame() {
        
    }
    public void gameMenu() {
        System.out.println("Start game? (y/n)");
        String op = scanner.nextLine();
        if(op.equalsIgnoreCase("y")){
            gameStart();
        }
    }

    public void gameStart() {
        
    }
}
