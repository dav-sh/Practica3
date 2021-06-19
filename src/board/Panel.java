package src.board;
public class Panel {
    private final int rows=8;
    private final int columns=8;
    private Cell[][] panel = new Cell[rows][columns];
    public Panel() {
        //vacio
    }
    public void createBoard() {
        System.out.println("\n\n");
        for (int i=0; i<rows; i++) {  //row
            for (int j=0; j<columns; j++){ //column
                if(i%2==0 && j%2==0){ //pair column and pair row
                    panel[i][j] = new Cell(2,false); //yellow
                }else if(i%2!=0 && j%2!=0){ //odd column and odd row
                    panel[i][j] = new Cell(2,false); //yellow
                }else{ //
                    panel[i][j] = new Cell(8,true); //white
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
        createBoard();
        for (int i=0; i<columns; i++){
            System.out.print("     "+i+"     ");
        }
        System.out.println("\n");
        for (int i=0; i<rows; i++){ //row
            for (int k=0; k<5; k++){  //height
                int tmp=0;
                for (int j=0; j<columns; j++){ //column
                    //for(int l=0; l<10;l++){ //width
                        //if(true){}
                            printPosition(3,3,k);
                        
                        System.out.print(panel[i][j].getCell());
                    }
                    if(k==2){
                        System.out.print("  "+i);
                        
                    }        
                    System.out.println("");
                }
            }
        System.out.println("\n\n");
    }

    public void printPosition(int i, int j, int k){
        if(k==2){
            panel[i][j].setCell("░░░░███░░░░");

        }else{
            panel[i][j].setCell("░░░░░░░░░░░");
        }
    }

}
