
public class Taikaneliotehdas {

    public Taikanelio luoTaikanelio(int koko) {

        Taikanelio nelio = new Taikanelio(koko);
        int numero = 1;
        int rivi = 0;
        int sarake = nelio.getLeveys() / 2;
        nelio.asetaArvo(sarake, rivi, numero);
        numero++;
        while (true) {
            if (numero == koko * koko + 1) {
                break;
            }
            rivi--;
            sarake++;

            if (rivi < 0) {
                rivi = nelio.getKorkeus() - 1;
            }
            if (sarake > nelio.getLeveys() - 1) {
                sarake = 0;
            }
            if (nelio.annaArvo(sarake, rivi) >= 1) {
                sarake--;
                rivi = rivi + 2;
                if (rivi >= nelio.getKorkeus()) {
                    rivi = rivi - nelio.getKorkeus();
                }
                if (sarake < 0) {
                    sarake = sarake + nelio.getKorkeus();
                }
            }
            nelio.asetaArvo(sarake, rivi, numero);
            numero++;
            // toteuta taikaneliön luominen Siamese method -algoritmilla tänne
        }
        return nelio;
    }
}
