public class Tavara {
    
    private String nimi;
    private int paino;
    
    public Tavara(String nimi, int paino) {
        this.paino = paino;
        this.nimi = nimi;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public int getPaino() {
        return this.paino;
    }
    
    public String toString() {
        return this.nimi + "(" + paino + " kg)";
    }
}
