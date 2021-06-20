package src.board;
public class Cell {
    private String cell;
    private int idColor;
    private String[] colors = new String[9];
    private boolean isOccupied,isWhite,player1;
    private String a = Character.toString((char)177);
    
    public Cell(int color, boolean isOccupied) {
        colors[0]="\u001B[0m";//reset
        colors[1]="\u001B[30m"; //black
        colors[2]="\u001B[31m"; //red
        colors[3]="\u001B[32m"; //green 
        colors[4]="\u001B[33m"; //yellow
        colors[5]="\u001B[34m"; //blue
        colors[6]="\u001B[35m"; //purple
        colors[7]="\u001B[36m"; //cyan
        colors[8]="\u001B[37m";//white
        this.idColor = color;
        this.cell = a+a+a+a+a+a+a+a+a+a+a;  //░   █
        this.isOccupied = isOccupied;
        this.isWhite = false;
        this.player1 = true;  //if is false (player2) else true (player1)

    }
    
    

    public String getCell() {
        return colors[idColor]+cell+colors[0];
    }
    public void setCell(String cell) {
        this.cell = cell;
    }
    public String color(int op) {
        
        return colors[op]+cell+colors[0];
    }

    public boolean getOccupied(){
        return isOccupied;
    }

    public void setOccupied(boolean Occupied){
        this.isOccupied = Occupied;
    }

    public boolean getIsWhite(){
        return isWhite;
    }

    public void setIsWhite(boolean IsWhite){
        this.isWhite = IsWhite;
    }

    public void resetCell(){
        this.cell = a+a+a+a+a+a+a+a+a+a+a;
    }
    public void setPlayer1(boolean status){
        this.player1 = status;
    }
    public boolean getPlayer1(){
        return this.player1;
    }


    public void printCell(){
        for(int i=0; i<4;i++) {
            for(int j=0; j<10; j++){
                System.out.print(getCell());
            }
            System.out.println("");
        }
    }
}
