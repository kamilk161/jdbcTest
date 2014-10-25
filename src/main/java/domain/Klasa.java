package domain;

import java.util.List;

public class Klasa {

    private Long id;

    private Integer nr;

    private Character oddzial;

    private List<Uczen> uczniowie;

    public Klasa(int nr, char oddzial) {
        this.nr = nr;
        this.oddzial = oddzial;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public List<Uczen> getUczniowie() {
        return uczniowie;
    }

    public void setUczniowie(List<Uczen> uczniowie) {
        this.uczniowie = uczniowie;
    }

    public Character getOddzial() {
        return oddzial;
    }

    public void setOddzial(char oddzial) {
        this.oddzial = oddzial;
    }

    @Override
    public String toString() {
        return "Klasa{" +
                "id=" + id +
                ", nr=" + nr +
                ", oddzial=" + oddzial +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
