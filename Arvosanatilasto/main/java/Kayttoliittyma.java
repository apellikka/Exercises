
import java.util.Scanner;

public class Kayttoliittyma {

    private Pisteidenhallinta pistelista;
    private Scanner lukija;

    public Kayttoliittyma(Pisteidenhallinta pistelista, Scanner lukija) {
        this.pistelista = pistelista;
        this.lukija = lukija;
    }

    public void kaynnista() {
        luePisteet();
        System.out.println("");
        tulostaArvosanat();
    }

    public void luePisteet() {
        System.out.println("Syötä yhteispisteet, -1 lopettaa: ");
        while (true) {
            String luettu = lukija.nextLine();
            if (luettu.equals("-1")) {
                break;
            }
            int luku = Integer.valueOf(luettu);
            if (luku >= 0 && luku <= 100) {
                this.pistelista.lisaa(luku);
                this.pistelista.lisaaArvosana(luku);
            }
        }
    }
    
    public void tulostaArvosanat() {
        System.out.println("Pisteiden keskiarvo (kaikki): " + pistelista.keskiarvo());
        System.out.println("Pisteiden keskiarvo (hyvaksytyt): " + pistelista.hyvaksyttyjenKeskiarvo());
        System.out.println("Hyvaksymisprosentti: " + pistelista.hyvaksymisprosentti());
        
        int arvosana = 5;
        while (arvosana >= 0) {
            int tahtia = pistelista.montakoSaanutArvosanan(arvosana);
            System.out.print(arvosana + ": ");
            tulostaTahtia(tahtia);
            System.out.println("");
            arvosana -= 1;
        }
    }
    
    public void tulostaTahtia(int tahtia) {
        while (tahtia > 0) {
            System.out.print("*");
            tahtia--;
        }
    }
}

