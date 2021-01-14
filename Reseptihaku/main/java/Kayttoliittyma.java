
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Kayttoliittyma {

    private Scanner lukija;
    private ArrayList<Resepti> reseptit = new ArrayList<Resepti>();

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
    }

    public void kaynnista() {
        lueTiedosto();
        System.out.println("");
        lueKayttajalta();
    }

    public void lueKayttajalta() {
        while (true) {
            System.out.println("Komennot:");
            System.out.println("listaa - listaa reseptit");
            System.out.println("lopeta - lopettaa ohjelman");
            System.out.println("hae nimi - hakee reseptiä nimen perusteella");
            System.out.println("hae keittoaika - hakee reseptia keittoajan perusteella");
            System.out.println("hae aine - hakee reseptiä raaka-aineen perusteella");
            System.out.print("Syötä komento:");
            String komento = lukija.nextLine();
            if (komento.equals("lopeta")) {
                break;
            }
            if (komento.equals("listaa")) {
                for (Resepti resepti : reseptit) {
                    System.out.println(resepti);
                }
            }
            if (komento.equals("hae nimi")) {
                System.out.println("Mitä haetaan?");
                String haettu = lukija.nextLine();
                for (Resepti resepti : reseptit) {
                    if (resepti.getNimi().contains(haettu)) {
                        System.out.println(resepti);
                    }
                }
            }
            if (komento.equals("hae keittoaika")) {
                System.out.println("Keittoaika korkeintaan: ");
                int keittoaika = Integer.valueOf(lukija.nextLine());
                for (Resepti resepti : reseptit) {
                    if (resepti.getKeittoaika() <= keittoaika) {
                        System.out.println(resepti);
                    }
                }
            }
            if (komento.equals("hae aine")) {
                System.out.println("Mitä raaka-ainetta haetaan?");
                String aine = lukija.nextLine();
                for (Resepti resepti : reseptit) {
                    if (resepti.getRaakaAineet().contains(aine)) {
                        System.out.println(resepti);
                    }
                }

            }
        }
    }

    public void lueTiedosto() {
        System.out.println("Mistä luetaan?");
        String luettu = lukija.nextLine();

        try ( Scanner tiedostonLukija = new Scanner(Paths.get(luettu))) {
            while (tiedostonLukija.hasNextLine()) {
                ArrayList<String> raakaAineet = new ArrayList<>();
                String nimi = tiedostonLukija.nextLine();
                int keittoaika = Integer.valueOf(tiedostonLukija.nextLine());

                while (tiedostonLukija.hasNextLine()) {
                    String aineet = tiedostonLukija.nextLine();
                    if (aineet.isEmpty()) {
                        break;
                    }
                    raakaAineet.add(aineet);
                }
                reseptit.add(new Resepti(nimi, keittoaika, raakaAineet));
            }

        } catch (Exception e) {
            System.out.println("Virhe: " + e + " luku epäonnistui");
        }
    }
}
