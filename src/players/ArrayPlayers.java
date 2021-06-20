
package src.players;
import java.util.*;

public class ArrayPlayers{
    private Player[] players=new Player[10];
    int idCounter;
    Scanner scanner = new Scanner(System.in);
    public ArrayPlayers(){
        idCounter=0;
    }
    public String getString(String mensaje){
        System.out.println(mensaje);
        String tmp = scanner.nextLine();
        return tmp;
    }
    public void addPlayer(){
        String name = getString("Enter the name of the player: " );
        if(idCounter<5){
            players[idCounter]=new Player((idCounter+1),name);
            System.out.println("\n\nSuccessfully added\n\n");
            idCounter++;
        }else{
            System.out.println("\n\nNo more players can be added ...\n\n");
        }
    }
    public void seePlayers(){
        for(int i=0; i<idCounter;i++){
            System.out.println(players[i].getInfo());
        }
    }


    public Player[] getPlayers(){
        return players;
    }
}