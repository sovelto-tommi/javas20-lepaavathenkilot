package fi.sovelto;

import java.time.LocalDate;
import java.util.Objects;

public class Henkilo {
    private String etunimi;
    private String sukunimi;
    private LocalDate syntymaaika;
    private int id;

    public Henkilo() {
        this("lapsi", "Sukunimi", LocalDate.now());
    }

    public Henkilo(String etunimi, String sukunimi) {
        this(etunimi, sukunimi, LocalDate.now());
    }

    public Henkilo(String etunimi, String sukunimi, LocalDate syntymaaika) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymaaika = syntymaaika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public LocalDate getSyntymaaika() {
        return syntymaaika;
    }

    public void setSyntymaaika(LocalDate syntymaaika) {
        this.syntymaaika = syntymaaika;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Henkilo{");
        sb.append("etunimi='").append(etunimi).append('\'');
        sb.append(", sukunimi='").append(sukunimi).append('\'');
        sb.append(", syntymaaika=").append(syntymaaika);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Henkilo henkilo = (Henkilo) o;
        return Objects.equals(etunimi, henkilo.etunimi) &&
                Objects.equals(sukunimi, henkilo.sukunimi) &&
                Objects.equals(syntymaaika, henkilo.syntymaaika);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etunimi, sukunimi, syntymaaika);
    }
}
