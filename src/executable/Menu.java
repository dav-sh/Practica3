package src.executable;
import src.players.ArrayPlayers;
import src.board.Panel;
import java.util.*;
import src.handlers.*;

public class Menu {
    private ArrayPlayers p = new ArrayPlayers();
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
            Handler h = new Handler();
            h.position();
            // Panel p = new Panel();
            // p.printBoard();
            //p.printBoard1();
        }
        

    }
}
