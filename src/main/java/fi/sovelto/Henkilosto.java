package fi.sovelto;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Henkilosto {
    private final List<Henkilo> henkilot = new ArrayList<>();

    public void lisaa(Henkilo h) {
        henkilot.add(h);
    }

    public boolean poista(Henkilo h) {
        Iterator<Henkilo> it = henkilot.iterator();
        while(it.hasNext()) {
            if (it.next().equals(h)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public List<Henkilo> kaikkiHenkilot() {
        return henkilot;
    }

    public List<Henkilo> kaikkiHenkilot(String sukunimi) {
        List<Henkilo> sopivat = henkilot.stream()
                .filter(h -> h.getSukunimi().equalsIgnoreCase(sukunimi))
                .collect(Collectors.toList());
        return sopivat;
    }

}
