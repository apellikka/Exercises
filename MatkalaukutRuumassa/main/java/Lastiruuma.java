import java.util.ArrayList;

public class Lastiruuma {

    private ArrayList<Matkalaukku> ruuma = new ArrayList<>();
    private int maksimipaino;
    
    public Lastiruuma(int maksimipaino) {
        this.maksimipaino = maksimipaino;
    }
    
    public void lisaaMatkalaukku(Matkalaukku laukku) {
        int yhteispaino = 0;
        for (Matkalaukku laukut : ruuma) {
            yhteispaino += laukut.yhteispaino();
        }
        if (laukku.yhteispaino() + yhteispaino <= maksimipaino)
        ruuma.add(laukku);
    }
    
    public String toString() {
        int yhteispaino = 0;
        for (Matkalaukku laukut : ruuma) {
            yhteispaino += laukut.yhteispaino();
        }
        return ruuma.size() + " matkalaukkua " + "(" + yhteispaino + " kg)";
    }
    
    public void tulostaTavarat() {
        for (Matkalaukku laukut : ruuma)
            laukut.tulostaTavarat();
    }
}
