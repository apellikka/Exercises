
import java.util.Map;
import java.util.HashMap;

public class Ostoskori {

    private Map<String, Ostos> ostokset;

    public Ostoskori() {
        this.ostokset = new HashMap<>();
    }

    public void lisaa(String tuote, int hinta) {
        if (ostokset.keySet().contains(tuote)) {
            ostokset.get(tuote).kasvataMaaraa();
        } else {
            Ostos ostos = new Ostos(tuote, 1, hinta);
            this.ostokset.put(tuote, ostos);
        }

    }

    public int hinta() {
        int hinta = 0;
        for (Ostos tuote : ostokset.values()) {
            hinta += tuote.hinta();
        }
        return hinta;
    }

    public void tulosta() {
        for (Ostos tuote : ostokset.values()) {
            System.out.println(tuote);
        }
    }
}
