package src.handlers;
import src.players.*;



public class HandlerPlayers{
    private Player[] p;
    private int player1id, player2id;
    public HandlerPlayers(Player[] players){
        this.p = players;
    }
    public void selectPlayers() {
        for(int i = 0; i <p.length; i++){
            if(p[i]!=null){

                System.out.println(p[i].getInfo());
            }else{
                break;
            }
        }

    }

    // public void print(){
    // }
}