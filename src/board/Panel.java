package src.board;
public class Panel {
    private final int rows=8;
    private final int columns=8;
    private Cell[][] panel = new Cell[rows][columns];
    private final String c = Character.toString((char)178);
    private final String a = Character.toString((char)177);
    public Panel() {
        
        createBoard();
    }
    public void createBoard() {
        System.out.println("\n\n");
        for (int i=0; i<rows; i++) {  //row
            for (int j=0; j<columns; j++){ //column
                if(i%2==0 && j%2==0){ //pair column and pair row
                    if(i==0 || i==6 || i==2){ //start in rows 0,1,2
                        panel[i][j] = new Cell(2,true); //red wwith yellow coins
                        if(i == 0 || i== 2){ 
                            panel[i][j].setPlayer1(false); // false to player 2 green
                        }
                    }else{
                        panel[i][j] = new Cell(2,false); //red
                    }
                }else if(i%2!=0 && j%2!=0){ //odd column and odd row
                    if(i==5 || i==1 || i==7){ //start in rows 5,6,7
                        panel[i][j] = new Cell(2,true); //red with green coins
                        if(i==1){
                            panel[i][j].setPlayer1(false); // false to player 2 green
                        }
                    }else{
                        panel[i][j] = new Cell(2,false); //red
                    }
                }else{ //
                    // Cell tmp = new Cell(8,false);
                    // tmp.setIsWhite(true); //chage is white to true
                    // panel[i][j] = tmp; //white
                    panel[i][j] = new Cell(8,false); //white
                    panel[i][j].setIsWhite(true);
                }
            }

        }
        
    }


    
    public void printBoard1(){
        for (int i=0; i<this.rows; i++){
            for (int j=0; j<this.columns; j++){
                System.out.print(panel[i][j].getCell());
            }
            System.out.println("");
        }
    }


    public void printBoard(){
        //print # of column
        numbersColumn();
        //print board
        System.out.println("\n");
        for (int i=0; i<rows; i++){ //row
            for (int k=0; k<5; k++){  //height
                for (int j=0; j<columns; j++){ //column
                        if(panel[i][j].getOccupied()){
                            changeCoin(i,j,k);
                        }
                        System.out.print(panel[i][j].getCell());
                    }
                    if(k==2){
                        System.out.print("  "+i); //print # of row
                    }        
                    System.out.println("");
                }
            }
        numbersColumn();
        System.out.println("\n\n");

    }








    public void printBoard(int x, int y, int x1,int y1){
        
        boolean tmp = true;
        if(!panel[x][y].getPlayer1()){ //
            tmp = false;   
        }
        resetCell(x,y,false,tmp);  //inicial celd
        resetCell(x1,y1,true,tmp); //move to new cell
        //print # of column
        numbersColumn();
        //print board
        System.out.println("\n");
        for (int i=0; i<rows; i++){ //row
            for (int k=0; k<5; k++){  //height
                for (int j=0; j<columns; j++){ //column
                            
                            changeCoin(x1,y1,k); //chance icon to new cell

                        
                        if(panel[i][j].getOccupied()){ //change icon of (true) occupied cells with coins 
                            changeCoin(i,j,k);
                        }
                        System.out.print(panel[i][j].getCell()); //print the cell 
                    }
                    if(k==2){
                        System.out.print("  "+i); //print # of row
                    }        
                    System.out.println("");
                }
            }
        numbersColumn();
        System.out.println("\n\n");
    }




    public void changeCoin(int x, int y, int k){
        String g ="\u001B[32m"; //green 
        String ye ="\u001B[33m"; //yellow
        String r ="\u001B[31m";//reset

        if(k==2){
            if(panel[x][y].getPlayer1()){
                panel[x][y].setCell(a+a+a+a+ye+c+c+c+r+a+a+a+a); //yellow coin
            }else{
                panel[x][y].setCell(a+a+a+a+g+c+c+c+r+a+a+a+a); //green coin

            }
            

        }else{
            panel[x][y].resetCell();

        }
    }


    public Cell[][] getPanel(){
        return panel;
    }


    public void setPanel(int x, int y, Cell[][] panel){
        this.panel[x][y] = panel[x][y];
    }


    public void resetCell(int x, int y,boolean isOccupied,boolean option){
        panel[x][y].setOccupied(isOccupied);   //tengo q modificar los valores de false y true de las celdas
        panel[x][y].resetCell();
        panel[x][y].setPlayer1(option);
    }





    public void numbersColumn(){
        for (int i=0; i<columns; i++){
            System.out.print("     "+i+"     ");
        }
    } 
}
