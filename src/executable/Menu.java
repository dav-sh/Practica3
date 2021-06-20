package src.executable;
import src.players.ArrayPlayers;
import src.board.Panel;
import java.util.*;
import src.handlers.*;

public class Menu {
    private ArrayPlayers p = new ArrayPlayers();
    private HandlerGame g; 
    Scanner scanner = new Scanner(System.in);
    public Menu() {
        //clear
    }
    private int getOption(String text) {
        System.out.println(text);
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }
    public void start() {
        int option;
        do{
            System.out.println("  Main Menu");
            System.out.println("1. Add new player");
            System.out.println("2. See player list");
            System.out.println("3. Print board");
            System.out.println("0. Exit");
            option = getOption("Enter the option:  ");
            selectMenu(option);
            
        }while(option!=0);
    }
    public void selectMenu(int option) {
        if(option == 1) {

            p.addPlayer();
        }
        if(option == 2){
            p.seePlayers();
        }
        if(option ==3){
            g =new HandlerGame(p.getPlayers());
            g.gameStart();
            // HandlerPlayers hp = new HandlerPlayers(p.getPlayers());
            // hp.selectPlayers(); //send players[]
            // //hp.print();

            // HandlerPanel h = new HandlerPanel();
            // h.position();
            // Panel p = new Panel();
            // p.printBoard();
            //p.printBoard1();
        }
        

    }
}
