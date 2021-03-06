
package src.players;
import java.util.*;

public class ArrayPlayers{
    final int numPlayers=10;
    private Player[] players=new Player[numPlayers];
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
        if(idCounter<numPlayers){
            players[idCounter]=new Player((idCounter+1),name);
            System.out.println("\n\nSuccessfully added\n\n");
            idCounter++;
        }else{
            System.out.println("\n\nNo more players can be added ...\n\n");
        }
    }
    public void seePlayers(){
        System.out.println("                        About Players");
        System.out.println("*****************************************************************");
        
        for(int i=0; i<idCounter;i++){
            players[i].getInfo();
        }
        System.out.println("*****************************************************************");

    }


    public Player[] getPlayers(){
        return players;
    }

    public void scoresTable(){
        Player[] playersScore = new Player[players.length];
        for(int i=0; i<idCounter;i++){
            playersScore[i]=players[i];
        }
        //aqui voy
        int position=0;
        Player change;
        for(int i=0; i<idCounter; i++){
            change = playersScore[i];
            position=i;
            for(int j=0;j<idCounter; j++){
                if(change.getGanadas()>playersScore[j].getGanadas()){
                    position =j;
                    change = playersScore[j];
                }
            }

            playersScore[position]=playersScore[i];
            playersScore[i]=change;
        }
        System.out.println("                        Ranking");
        System.out.println("*****************************************************************");
        for(int i=0; i<idCounter;i++){
            System.out.printf("%-2d name: %-25s        wins: %-3d%n",(i+1),playersScore[i].getName(), playersScore[i].getGanadas());
        }
        System.out.println("*****************************************************************");


    }


}