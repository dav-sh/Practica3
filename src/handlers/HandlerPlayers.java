package src.handlers;
import src.players.*;
import java.util.*;


public class HandlerPlayers{
    private Player[] p;
    private int player1id, player2id;
    Scanner scanner = new Scanner(System.in);




    public HandlerPlayers(Player[] players){
        this.p = players;
    }




    public boolean okPlayers() {
        
        int count = printListPlayers();
        int id1,id2;
        if(count>=2){
            
            return true;
        }else{
            System.out.println("Please, add more players");
            return false;
        }
        
    }




    public int printListPlayers(){
        int count = 0;
        for(int i = 0; i <p.length; i++){
            if(p[i]!=null){

                System.out.println(p[i].getInfo());
                count++;
            }else{
                break;
            }
        }return count;
    }

    private int getEntero(String message){
        System.out.println(message);
        int tmp = scanner.nextInt();
        scanner.nextLine();
        return tmp;
    }

    public boolean verifyPlayers(){

        int count = 0;
        for(int i = 0; i <p.length; i++){
            if(p[i]!=null){
                count++;
            }
        }
        if(count>=2){
            return true;
        }else{
            return false;
        }
    }

    private int verifyId(int id){
        do{
            if(p[id-1].getId()!=0){ //id is enter by user
                break;
            }
        }while(id==0);
        
        return id;
        
    }


    
    public int selectPlayersid(int i){
        return  verifyId(getEntero("Enter player #"+(1+i)+" (id): ")); //first catch the number and after verify id is not 0
    }

    public void addScore(int id){
        p[id].setGanadas((p[id].getGanadas()+1));
        System.out.println("ganadas "+ p[id].getGanadas()+ " id "+(id+1));
    }






    // public boolean selectPlayers(){
    //     if(verifyPlayers()){
    //         // int id2 = verifyId(getEntero("Enter player #"+(2)+" (id): "));
    //         // System.out.println(id1+" "+id2);
    //         return true;
    //     }else{
    //         return false;
    //     }
        
    // }
    
}