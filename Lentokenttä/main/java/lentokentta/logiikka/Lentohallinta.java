package lentokentta.logiikka;

import java.util.Collection;
import lentokentta.domain.Lento;
import lentokentta.domain.Lentokone;
import java.util.HashMap;
import java.util.Map;
import lentokentta.domain.Paikka;

public class Lentohallinta {

    private Map<String, Lentokone> lentokoneet;
    private Map<String, Lento> lennot;
    private Map<String, Paikka> paikat;

    public Lentohallinta() {
        this.lentokoneet = new HashMap<>();
        this.lennot = new HashMap<>();
        this.paikat = new HashMap<>();
    }

    public void lisaaLentokone(String tunnus, int kapasiteetti) {
        Lentokone lentokone = new Lentokone(tunnus, kapasiteetti);
        lentokoneet.put(tunnus, lentokone);
    }

    public void lisaaLento(Lentokone lentokone, String lahtopaikka, String kohdepaikka) {
        this.paikat.putIfAbsent(lahtopaikka, new Paikka(lahtopaikka));
        this.paikat.putIfAbsent(kohdepaikka, new Paikka(kohdepaikka));

        Lento lento = new Lento(lentokone, this.paikat.get(lahtopaikka), this.paikat.get(kohdepaikka));
        this.lennot.put(lento.toString(), lento);
    }

    public Collection<Lentokone> getLentokoneet() {
        return this.lentokoneet.values();
    }

    public Collection<Lento> getLennot() {
        return this.lennot.values();
    }

    public Lentokone haeLentokone(String tunnus) {
        return this.lentokoneet.get(tunnus);
    }
}
