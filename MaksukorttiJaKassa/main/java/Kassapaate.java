
public class Kassapaate {

    private double rahaa;  // kassassa olevan käteisen määrä
    private int edulliset; // myytyjen edullisten lounaiden määrä
    private int maukkaat;  // myytyjen maukkaiden lounaiden määrä

    public Kassapaate() {
        rahaa = 1000;
    }

    public double syoEdullisesti(double maksu) {
        if (maksu < 2.50) {
            return maksu;
        }
        rahaa = rahaa + 2.50;
        edulliset++;
        // edullinen lounas maksaa 2.50 euroa.
        // päivitetään kassan rahamäärää lounaan hinnalla ja palautetaan vaihtorahat
        // jos parametrina annettu maksu ei ole riittävän suuri, ei lounasta myydä ja metodi palauttaa koko summan
        return maksu - 2.50;
    }

    public double syoMaukkaasti(double maksu) {
        if (maksu < 4.30) {
            return maksu;
        }
        rahaa = rahaa + 4.30;
        maukkaat++;
        // maukas lounas maksaa 4.30 euroa.
        // päivitetään kassan rahamäärää lounaan hinnalla ja palautetaan vaihtorahat
        // jos parametrina annettu maksu ei ole riittävän suuri, ei lounasta myydä ja metodi palauttaa koko summan
        return maksu - 4.30;
    }

    public boolean syoEdullisesti(Maksukortti kortti) {
        if (kortti.saldo() >= 2.50) {
            kortti.otaRahaa(2.50);
            edulliset++;
            return true;
        }
        return false;
    }

    public boolean syoMaukkaasti(Maksukortti kortti) {
        if (kortti.saldo() >= 4.30) {
            kortti.otaRahaa(4.30);
            maukkaat++;
            return true;
        }
        return false;
    }
    
    public void lataaRahaaKortille(Maksukortti kortti, double summa) {
        if (summa > 0) {
        kortti.lataaRahaa(summa);
        rahaa = rahaa + summa;
        }
    }

    @Override
    public String toString() {
        return "kassassa rahaa " + rahaa + " edullisia lounaita myyty "
                + edulliset + " maukkaita lounaita myyty " + maukkaat;
    }
}
