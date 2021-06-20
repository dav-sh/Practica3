package src.handlers;
import src.players.*;
import src.board.*;
import java.util.*;

public class HandlerGame {
    private int idP1,idP2;
    private Player[] p;
    Scanner scanner = new Scanner(System.in);
    private HandlerPlayers hPlayers; 
    private HandlerPanel hPanel;// = new HandlerPanel();




    public HandlerGame(Player[] players) {
        //this.hp = players;
        this.hPlayers = new HandlerPlayers(players);
    }




    public void gameMenu() {
            gameStart();
    }





    public void gameStart() {
        boolean tmp =hPlayers.verifyPlayers(); //send players[]
        if(tmp) {
            for(int i=0; i<2;i++){
                if(i==0){
                    idP1=hPlayers.selectPlayersid(i);
                    System.out.println("Player: "+idP1);

                }else{
                    idP2=hPlayers.selectPlayersid(i);
                    System.out.println("Player: "+idP2);
                }
            }

        }else{
            System.out.println("Please add more players\n\n");
        }
        if(tmp) {
            hPanel = new HandlerPanel();
            int id = whoStart(idP1,idP2);
            inGame(id);

        }
        
    }


    public int change(int player){
        if(player == idP1){
            return idP2;
        }else{
            return idP1;
        }
    }
    
    public void printPosition(int id){
        System.out.println("Player : "+id);
        int tmpId = id;

        boolean tmp = false;
        do{
            tmp= hPanel.position();
            tmpId=change(id);
            System.out.println("Id temporal: "+tmpId);
            hPlayers.addScore(id);
        }while(!tmp);
    }

    public void inGame(int id){
        //int turno = id;
        printPosition(id);

    }






    public int whoStart(int idP1, int idP2){
        System.out.println("Player losser: "+idP2);
        return idP1;
        // Random rand = new Random();
        // System.out.println("Rock vs Paper vs Scissors");
        // String []game = {"rock","paper","scissors"}; 
        // String p1,p2;
        // boolean exit = false;
        // while(!exit){
        //     for(int i = 0; i <2;i++){
        //         int option =rand.nextInt(3);
        //         if(i==0){
        //             p1=game[option];
        //         }else{
        //             p2=game[option];
        //         }
        //     }
        //     if(p1.equals("rock")&&p2.equals("scissors")  ||  p1.equals("scissors")&&p2.equals("rock") ){
        //         if(p1.equals("scissors")){
        //             return idP1;
        //         }else{
        //             return idP2;
        //         }
        //         exit = true;
        //     }
        //     else if(p1.equals("paper")&&p2.equals("scissors")  ||  p1.equals("scissors")&&p2.equals("paper")){
        //         if(p1.equals("paper")){
        //             return idP1;
        //         }else{
        //             return idP2;
        //         exit = true;
        //     }
        //     }
        //     else if(p1.equals("rock")&&p2.equals("paper")  ||  p1.equals("paper")&&p2.equals("rock")){
        //         if(p1.equals("rock")){
        //             return idP1;
        //         }else{
        //             return idP2;
        //         }
        //         exit = true;
        //     }
        // }
    }



}
