import java.util.ArrayList;

public class Resepti {
    
    private String nimi;
    private int keittoaika;
    private ArrayList<String> raakaAineet;
    
    public Resepti(String nimi, int keittoaika, ArrayList<String> raakaAineet) {
       this.raakaAineet = raakaAineet;
       this.nimi = nimi;
       this.keittoaika = keittoaika;
    }

    public String getNimi() {
        return this.nimi;
    }
    
    public int getKeittoaika() {
        return this.keittoaika;
    }
    
    public ArrayList<String> getRaakaAineet() {
        return this.raakaAineet;
    }
    
    public String toString() {
        return this.getNimi() + ", keittoaika: " + this.getKeittoaika();
    }
}
