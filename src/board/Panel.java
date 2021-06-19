package src.board;
public class Panel {
    private final int rows=8;
    private final int columns=8;
    public Panel() {
        //vacio
    }
    public void printBoard() {
        System.out.println(" ");
        for (int i=0; i<rows; i++) {  //row
            for (int j=0; j<columns; j++){ //column
                
                
                if(i%2==0){ //par row
                    if(j%2==0){ //par column
                        Box b = new Box();
                        //System.out.print(b.color(5)+b.getCell()+b.color(0));
                        returnCell(i, b);
                        System.out.print(b.getCell());
                    }else{ //odd column
                        Box c = new Box();
                        System.out.print(c.getSpace());
                    }

                }else{ //odd row
                    if(j%2==0){ //par column
                        Box b = new Box();
                        System.out.print(b.getSpace());
                    }else{ //odd column
                        Box c = new Box();
                        returnCell(i,c);
                        System.out.print(c.getCell());
                    }
                }
            }System.out.println(" ");

        }
        System.out.println(" ");

    }
    public void returnCell(int i, Box b){
        if(i==0 || i==2 || i==1){
            b.setCell("|xx|");
        }else if(i==3 || i==4){
            b.setCell("||||");
        }else if(i==6 || i==7 || i==5){
            b.setCell("|yy|");
        }
    }

}
