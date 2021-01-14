

public class Ostos {
    
    private String tuote;
    private int maara;
    private int hinta;
    
    
    public Ostos(String tuote, int kpl, int yksikkohinta) {
        this.tuote = tuote;
        this.maara = kpl;
        this.hinta = yksikkohinta;
    }
    
    public int hinta() {
        return this.maara * this.hinta;
    }
    
    public void kasvataMaaraa() {
        this.maara++;
    }
    
    @Override
    public String toString() {
        return this.tuote + ": " + this.maara;
    }
    
}
