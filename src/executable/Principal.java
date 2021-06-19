package src.executable;

public class Principal{
    public static void main(String[] args){
        Principal m = new Principal();
    }
    public Principal(){
        Menu menu = new Menu();
        menu.start();
    }
}