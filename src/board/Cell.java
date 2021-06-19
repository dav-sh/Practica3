package src.board;
public class Cell {
    private String cell,coin;
    private int idColor;
    private String[] colors = new String[9];
    private boolean isOccupied;
    
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
        this.cell = "░░░░░░░░░░░";  //░   █
        this.coin = "█";
        this.isOccupied = isOccupied;

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

    public boolean getOcuppied(){
        return isOccupied;
    }

    public void setOcuppied(boolean Ocuppied){
        this.isOccupied = Ocuppied;
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
