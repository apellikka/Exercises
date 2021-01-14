
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Reseptihaku {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Kayttoliittyma kali = new Kayttoliittyma(lukija);
        
        kali.kaynnista();
        
}
}