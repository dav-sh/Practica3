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
                    if(i==0 || i==6 || i==2){ //start in rows 0,1,2
                        panel[i][j] = new Cell(2,false); //yellow
                    }else{
                        panel[i][j] = new Cell(2,true); //yellow
                    }
                }else if(i%2!=0 && j%2!=0){ //odd column and odd row
                    if(i==5 || i==1 || i==7){ //start in rows 5,6,7
                    panel[i][j] = new Cell(2,false); //yellow
                    }else{
                        panel[i][j] = new Cell(2,true); //yellow
                    }
                }else{ //
                    Cell tmp = new Cell(8,true);
                    tmp.setIsWhite(true); //chage is white to true
                    panel[i][j] = tmp; //white
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
        //print # of column
        numbersColumn();
        //print board
        System.out.println("\n");
        for (int i=0; i<rows; i++){ //row
            for (int k=0; k<5; k++){  //height
                for (int j=0; j<columns; j++){ //column
                        if(!panel[i][j].getOcuppied()){
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







    public void printBoard(int x, int y, boolean change){

        //print # of column
        numbersColumn();
        //print board
        System.out.println("\n");
        for (int i=0; i<rows; i++){ //row
            for (int k=0; k<5; k++){  //height
                for (int j=0; j<columns; j++){ //column
                        if(change){  //move a coin

                            changeCoin(x,y,k);
                        }
                        if(!panel[i][j].getOcuppied()){ //print all false occupied coins 
                            changeCoin(i,j,k);
                        }
                        System.out.print(panel[i][j].getCell()); //[rint the cell
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
        String c = Character.toString((char)178);
        String a = Character.toString((char)177);
        if(k==2){
            //panel[x][y].setCell("░░░░███░░░░");

            panel[x][y].setCell(a+a+a+a+c+c+c+a+a+a+a);

        }else{
            panel[x][y].setCell(a+a+a+a+a+a+a+a+a+a+a);

            //panel[x][y].setCell("░░░░░░░░░░░");
        }
    }

    public Cell[][] getPanel(){
        return panel;
    }

    public void setPanel(int x, int y, Cell[][] panel){
        this.panel[x][y] = panel[x][y];
    }






    public void numbersColumn(){
        for (int i=0; i<columns; i++){
            System.out.print("     "+i+"     ");
        }
    } 
}
