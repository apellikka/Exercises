package sanakirja;

import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.PrintWriter;

public class MuistavaSanakirja {

    private HashMap<String, String> kaannokset;
    private String tiedosto;

    public MuistavaSanakirja() {
        this.kaannokset = new HashMap<>();
    }

    public MuistavaSanakirja(String tiedosto) {
        this.tiedosto = tiedosto;
        this.kaannokset = new HashMap<>();
    }

    public void lisaa(String sana, String kaannos) {
        this.kaannokset.putIfAbsent(sana, kaannos);
    }

    public String kaanna(String kaanna) {
        if (kaannokset.containsKey(kaanna)) {
            return kaannokset.get(kaanna);
        }
        for (String key : kaannokset.keySet()) {
            if (kaannokset.get(key).equals(kaanna)) {
                return key;
            }
        }
        return null;
    }

    public void poista(String sana) {
        if (kaannokset.containsKey(sana)) {
            kaannokset.remove(sana);
        } else {
            String poistettava = "";
            for (String key : kaannokset.keySet()) {
                if (kaannokset.get(key).equals(sana)) {
                    poistettava += key;
                }
            }
            kaannokset.remove(poistettava);
        }
    }

    public boolean lataa() {
        try ( Scanner lukija = new Scanner(Paths.get(this.tiedosto))) {
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] osat = rivi.split(":");
                this.kaannokset.put(osat[0], osat[1]);
            }
        } catch (Exception e) {
            System.out.println("Virhe");
            return false;
        }
        return true;
    }

    public boolean tallenna() {
        try ( PrintWriter kirjoittaja = new PrintWriter(this.tiedosto)) {
            for (String key : kaannokset.keySet()) {
                kirjoittaja.println(key + ":" + kaannokset.get(key));
            }
        } catch (Exception e) {
            System.out.println("Virhe");
            return false;
        }
        return true;
    }
}
