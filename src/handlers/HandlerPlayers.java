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




    public void selectPlayers() {
        int count = printListPlayers();
        int id1,id2;
        if(count>=2){
            id1 = verifyId(getEntero("Enter player #"+(1)+" (id): "));
            id2 = verifyId(getEntero("Enter player #"+(2)+" (id): "));
            System.out.println(id1+" "+id2);
        }else{
            System.out.println("Please, add more players");
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

    private int verifyId(int id){
        int cont = 0;
        while(cont==0){
            if(p[id-1].getId()!=0){
                cont = 1;
            }

        }
        
        return id;
        
    }
}