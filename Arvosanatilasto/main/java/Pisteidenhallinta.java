
import java.util.ArrayList;

public class Pisteidenhallinta {

    private ArrayList<Integer> rekisteri;
    private ArrayList<Integer> arvosanat;

    public Pisteidenhallinta() {
        this.rekisteri = new ArrayList<>();
        this.arvosanat = new ArrayList<>();
    }

    public void lisaa(int piste) {
        rekisteri.add(piste);
    }
    
    public int montakoSaanutArvosanan(int arvosana) {
        int lkm = 0;
        for (int saatu : arvosanat) {
            if (saatu == arvosana) {
                lkm++;
            }
        }
        return lkm;
    }

    public void lisaaArvosana(int piste) {
        int arvosana = 0;
        if (piste < 50) {
            arvosana = 0;
        }
        else if (piste < 60) {
            arvosana = 1;
        }
        else if (piste < 70) {
            arvosana = 2;
        }
        else if (piste < 80) {
            arvosana = 3;
        }
        else if (piste < 90) {
            arvosana = 4;
        } else {
            arvosana = 5;
        }
        arvosanat.add(arvosana);
    }

    public double keskiarvo() {
        int summa = 0;
        for (int pisteita : rekisteri) {
            summa += pisteita;
        }
        return 1.0 * summa / rekisteri.size();
    }

    public double hyvaksyttyjenKeskiarvo() {
        int summa = 0;
        int lkm = 0;
        for (int pisteita : rekisteri) {
            if (pisteita >= 50 && pisteita <= 100) {
                summa += pisteita;
                lkm++;
            }
        }
        return 1.0 * summa / lkm;
    }

    public double hyvaksymisprosentti() {
        int lkm = 0;
        for (int piste : rekisteri) {
            if (piste >= 50 && piste <= 100) {
                lkm++;
            }
        }
        return 100.0 * lkm / rekisteri.size();
    }
}
