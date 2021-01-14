
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Varasto {

    private Map<String, Integer> tuotteet;
    private Map<String, Integer> saldo;

    public Varasto() {
        this.tuotteet = new HashMap<>();
        this.saldo = new HashMap<>();
    }

    public void lisaaTuote(String tuote, int hinta, int saldo) {
        this.tuotteet.put(tuote, hinta);
        this.saldo.put(tuote, saldo);
    }

    public int hinta(String tuote) {
        if (!tuotteet.containsKey(tuote)) {
            return -99;
        }
        return tuotteet.get(tuote);
    }

    public int saldo(String tuote) {
        if (!saldo.containsKey(tuote)) {
            return 0;
        }
        return saldo.get(tuote);
    }

    public boolean ota(String tuote) {
        if (!saldo.containsKey(tuote) || saldo.get(tuote).equals(0)) {
            return false;
        } else if (saldo.get(tuote) > 0) {
            saldo.put(tuote, saldo.getOrDefault(tuote, 0) - 1);
        }
        return true;
    }

    public Set<String> tuotteet() {
        return tuotteet.keySet();
    }
}
