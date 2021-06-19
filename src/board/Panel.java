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
                    panel[i][j] = new Cell(2); //yellow
                }else if(i%2!=0 && j%2!=0){ //odd column and odd row
                    panel[i][j] = new Cell(2); //yellow
                }else{ //
                    panel[i][j] = new Cell(8); //white
                }
            }

        }
        
    }
    public void printBoard(){
        createBoard();
        for (int i=0; i<rows; i++){ //row
            for (int k=0; k<4; k++){  //height
                for (int j=0; j<columns; j++){ //column
                    for(int l=0; l<10;l++){ //width
                        System.out.print(panel[i][j].getCell());
                    }
                }
                System.out.println("");

            }
        }
        System.out.println("\n\n");
    }
    

}
