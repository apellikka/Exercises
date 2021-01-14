package lentokentta;

import java.util.Scanner;
import lentokentta.logiikka.Lentohallinta;
import lentokentta.ui.Kayttoliittyma;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        Lentohallinta hallinta = new Lentohallinta();
        Kayttoliittyma kali = new Kayttoliittyma(hallinta, lukija);
        
        kali.kaynnista();
    }
}
