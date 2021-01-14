
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        Pisteidenhallinta pisteet = new Pisteidenhallinta();
        Kayttoliittyma kali = new Kayttoliittyma(pisteet, lukija);
        
        kali.kaynnista();
    }
}
