import java.util.ArrayList;

public class Matkalaukku {

    private ArrayList<Tavara> tavarat = new ArrayList<>();
    private int maksimipaino;
    
    public Matkalaukku(int maksimipaino) {
    this.maksimipaino = maksimipaino;
}
    
    public void lisaaTavara(Tavara tavara) {
        if (tavara.getPaino() + yhteispaino() <= maksimipaino) {
        tavarat.add(tavara);
        }
    }
    
    public void tulostaTavarat() {
        for (Tavara tavara : tavarat) {
            System.out.println(tavara);
        }
    }
    
    public int yhteispaino() {
        int yhteispaino = 0;
        for (Tavara tavara : tavarat) {
            yhteispaino += tavara.getPaino();
        }
        return yhteispaino;
    }
    
    public Tavara raskainTavara() {
        if (tavarat.isEmpty()) {
            return null;
        }
        Tavara painavin = tavarat.get(0);
        
        for(Tavara tavara : tavarat) {
            if (painavin.getPaino() < tavara.getPaino()) {
                painavin = tavara;
            }
        }
        return painavin;
    }
    
    public String toString() {
        if (tavarat.isEmpty()) {
            return "ei tavaroita (0 kg)";   
        }
        if (tavarat.size() == 1) {
            return this.tavarat.size() + " tavara " + "(" + yhteispaino() + " kg)";
        }
        return this.tavarat.size() + " tavaraa " + "(" + yhteispaino() + " kg)";
    } 
}
