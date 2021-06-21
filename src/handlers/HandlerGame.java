package src.handlers;
import src.players.*;
import src.board.*;
import java.util.*;

public class HandlerGame {
    private int idP1,idP2;
    //private Player[] p;
    Scanner scanner = new Scanner(System.in);
    private HandlerPlayers hPlayers; 
    private HandlerPanel hPanel;// = new HandlerPanel();
    Random rand = new Random();





    public HandlerGame(Player[] players) {
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
                    idP1=hPlayers.selectPlayersid(i); // i is only for print player #1
                    System.out.println("Player: "+idP1);

                }else{
                    idP2=hPlayers.selectPlayersid(i); //here catch id p2
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



    
    
    public void printPosition(int id){ //id == idP1 or idP2
        
        boolean tmp = true;
        do{
            if(id == idP1){
                System.out.println("Turn Player : 1 ");
            }else if(id == idP2){
                System.out.println("Turn Player : 2 ");
            }
            tmp= hPanel.position();
            hPlayers.addScore(id-1);
            id=change(id);
        }while(tmp);
        System.out.println("End Game");
    }







    public void inGame(int id){
        printPosition(id);

    }






    public int whoStart(int idP1, int idP2){
        //System.out.println("Player losser: "+idP2);
        int id=idP1;
        System.out.println("Who start? .... well");
        System.out.println("Rock vs Paper vs Scissors");
        String []game = {"rock","paper","scissors"}; 
        String p1="";
        String p2="";
        boolean exit = false;
        while(!exit){
            for(int i = 0; i <2;i++){
                int option =rand.nextInt(3);
                if(i==0){
                    p1=game[option];
                }else{
                    p2=game[option];
                }
            }
            System.out.println("Player 1: "+p1);
            System.out.println("Player 2: "+p2);
            if(p1.equals("rock")&&p2.equals("scissors")  ||  p1.equals("scissors")&&p2.equals("rock") ){
                if(p1.equals("rock")){
                    id= idP1;
                }else if(p1.equals("scissors")){
                    id= idP2;
                }
                System.out.println("l1"+id);
                exit = true;
            }
            else if(p1.equals("paper")&&p2.equals("scissors")  ||  p1.equals("scissors")&&p2.equals("paper")){
                if(p1.equals("scissors")){
                    id= idP1;
                }else if(p1.equals("paper")){
                    id= idP2;
                exit = true;
                System.out.println("l2"+id);

                }
            }
            else if(p1.equals("rock")&&p2.equals("paper")  ||  p1.equals("paper")&&p2.equals("rock")){
                if(p1.equals("paper")){
                    id= idP1;
                }else if (p1.equals("rock")){
                    id= idP2;
                }
                exit = true;
                System.out.println("l2"+id);

            }
        }
        if(id==idP1){
            System.out.println("Win Player 1");

        }else{
            System.out.println("Win Player 2");

        }
        return id;
    }



}
