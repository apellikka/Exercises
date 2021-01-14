package lentokentta.ui;

import lentokentta.domain.Lento;
import lentokentta.domain.Lentokone;
import java.util.Scanner;
import lentokentta.logiikka.Lentohallinta;

public class Kayttoliittyma {

    private Lentohallinta lentohallinta;
    private Scanner lukija;

    public Kayttoliittyma(Lentohallinta hallinta, Scanner lukija) {
        this.lentohallinta = hallinta;
        this.lukija = lukija;
    }

    public void kaynnista() {

        kaynnistaLentokentanHallinta();
        System.out.println("");
        kaynnistaLentoPalvelu();
        System.out.println("");

    }

    private void kaynnistaLentokentanHallinta() {
        System.out.println("Lentokentän hallinta");
        System.out.println("--------------------");
        System.out.println();

        while (true) {
            System.out.println("Valitse toiminto:");
            System.out.println("[1] Lisää lentokone");
            System.out.println("[2] Lisää lento");
            System.out.println("[x] Poistu hallintamoodista");

            System.out.print("> ");
            String vastaus = lukija.nextLine();

            if (vastaus.equals("1")) {
                lisaaLentokone();
            } else if (vastaus.equals("2")) {
                lisaaLento();
            } else if (vastaus.equals("x")) {
                break;
            }
        }

    }

    private void lisaaLentokone() {
        System.out.println("Anna lentokoneen tunnus: ");
        String tunnus = lukija.nextLine();
        System.out.println("Anna lentokoneen kapasiteetti: ");
        int kapasiteetti = Integer.valueOf(lukija.nextLine());

        this.lentohallinta.lisaaLentokone(tunnus, kapasiteetti);
    }

    private void lisaaLento() {
        System.out.println("Anna lentokoneen tunnus: ");
        Lentokone kone = kysyLentokone();
        System.out.println("Anna lähtöpaikan tunnus: ");
        String lahtotunnus = lukija.nextLine();
        System.out.println("Anna kohdepaikan tunnus: ");
        String kohdepaikka = lukija.nextLine();

        this.lentohallinta.lisaaLento(kone, lahtotunnus, kohdepaikka);
    }

    private void kaynnistaLentoPalvelu() {
        System.out.println("Lentopalvelu");
        System.out.println("------------");
        System.out.println();

        while (true) {
            System.out.println("Valitse toiminto:");
            System.out.println("[1] Tulosta lentokoneet");
            System.out.println("[2] Tulosta lennot");
            System.out.println("[3] Tulosta lentokoneen tiedot");
            System.out.println("[x] Lopeta");

            System.out.print("> ");
            String vastaus = lukija.nextLine();
            if (vastaus.equals("1")) {
                tulostaLentokoneet();
            } else if (vastaus.equals("2")) {
                tulostaLennot();
            } else if (vastaus.equals("3")) {
                tulostaLentokone();
            } else if (vastaus.equals("x")) {
                break;
            }
        }
    }

    private void tulostaLentokoneet() {
        for (Lentokone kone : lentohallinta.getLentokoneet()) {
            System.out.println(kone);
        }
    }

    private void tulostaLennot() {
        for (Lento lento : lentohallinta.getLennot()) {
            System.out.println(lento);
        }
    }

    private void tulostaLentokone() {
        System.out.println("Mikä kone: ");
        Lentokone kone = kysyLentokone();
        System.out.println(kone);
    }

    private Lentokone kysyLentokone() {
        Lentokone lentokone = null;
        while (lentokone == null) {
            String tunnus = lukija.nextLine();
            lentokone = lentohallinta.haeLentokone(tunnus);

            if (lentokone == null) {
                System.out.println("Tunnuksella " + tunnus + " ei ole lentokonetta.");
            }
        }
        return lentokone;
    }
}
