
import java.util.ArrayList;
import java.util.Collections;

public class Taikanelio {

    private int[][] nelio;

    // valmis konstruktori
    public Taikanelio(int koko) {
        if (koko < 2) {
            koko = 2;
        }

        this.nelio = new int[koko][koko];
    }

    // toteuta nämä kolme metodia
    public ArrayList<Integer> rivienSummat() {
        ArrayList<Integer> summat = new ArrayList<>();
        int summa = 0;
        for (int i = 0; i < getLeveys(); i++) {
            for (int j = 0; j < nelio[i].length; j++) {
                summa += nelio[i][j];
            }
            summat.add(summa);
            summa = 0;
        }
        return summat;
    }

    public ArrayList<Integer> sarakkeidenSummat() {
        ArrayList<Integer> summat = new ArrayList<>();
        int summa = 0;
        for (int i = 0; i < getKorkeus(); i++) {
            for (int j = 0; j < nelio[i].length; j++) {
                summa += nelio[j][i];
            }
            summat.add(summa);
            summa = 0;
        }
        return summat;
    }

    public ArrayList<Integer> lavistajienSummat() {
        ArrayList<Integer> summat = new ArrayList<>();
        int summa1 = 0;
        int summa2 = 0;
        for (int i = 0; i < getLeveys(); i++) {
            for (int j = 0; j < nelio[i].length; j++) {
                if (i == j) {
                    summa1 += nelio[i][j];
                }
                if (i + j == getLeveys() - 1) {
                    summa2 += nelio[i][j];
                }
            }
        }
        summat.add(summa1);
        summat.add(summa2);
        return summat;
    }

    // valmiit apumetodit -- älä koske näihin
    public boolean onTaikanelio() {
        return summatSamat() && kaikkiNumerotEri();
    }

    public ArrayList<Integer> annaKaikkiNumerot() {
        ArrayList<Integer> numerot = new ArrayList<>();
        for (int rivi = 0; rivi < nelio.length; rivi++) {
            for (int sarake = 0; sarake < nelio[rivi].length; sarake++) {
                numerot.add(nelio[rivi][sarake]);
            }
        }

        return numerot;
    }

    public boolean kaikkiNumerotEri() {
        ArrayList<Integer> numerot = annaKaikkiNumerot();

        Collections.sort(numerot);
        for (int i = 1; i < numerot.size(); i++) {
            if (numerot.get(i - 1) == numerot.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean summatSamat() {
        ArrayList<Integer> summat = new ArrayList<>();
        summat.addAll(rivienSummat());
        summat.addAll(sarakkeidenSummat());
        summat.addAll(lavistajienSummat());

        if (summat.size() < 3) {
            return false;
        }

        for (int i = 1; i < summat.size(); i++) {
            if (summat.get(i - 1) != summat.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int annaArvo(int x, int y) {
        if (x < 0 || y < 0 || x >= getLeveys() || y >= getKorkeus()) {
            return - 1;
        }

        return this.nelio[y][x];
    }

    public void asetaArvo(int x, int y, int arvo) {
        if (x < 0 || y < 0 || x >= getLeveys() || y >= getKorkeus()) {
            return;
        }

        this.nelio[y][x] = arvo;
    }

    public int getLeveys() {
        return this.nelio.length;
    }

    public int getKorkeus() {
        return this.nelio.length;
    }

    @Override
    public String toString() {
        StringBuilder palautus = new StringBuilder();
        for (int rivi = 0; rivi < nelio.length; rivi++) {
            for (int sarake = 0; sarake < nelio[rivi].length; sarake++) {
                palautus.append(nelio[rivi][sarake]).append("\t");
            }

            palautus.append("\n");
        }

        return palautus.toString();
    }
}
