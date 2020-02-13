package fi.sovelto;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Henkilosto {
    private final List<Henkilo> henkilot = new ArrayList<>();
    private static int seuraavaId = 1;

    public void lisaa(Henkilo h) {
        h.setId(seuraavaId++);
        henkilot.add(h);
    }

    public void lisaaKaikki(Collection<Henkilo> uudet) {
        uudet.stream().forEach(h -> h.setId(seuraavaId++));
        henkilot.addAll(uudet);
    }

    public boolean poista(Henkilo h) {
        return poista(h.getId());
/*
        Iterator<Henkilo> it = henkilot.iterator();
        while(it.hasNext()) {
            if (it.next().equals(h)) {
                it.remove();
                return true;
            }
        }
        return false;
*/
    }

    public boolean poista(int id) {
        Iterator<Henkilo> it = henkilot.iterator();
        while(it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Optional<Henkilo> haeIdlla(int id) {
        for(Henkilo h : henkilot) {
            if (h.getId() == id) {
                return Optional.of(h);
            }
        }
        return Optional.empty();
    }

    public List<Henkilo> kaikkiHenkilot() {
        // defensive copy
        return new ArrayList<>(henkilot);
    }

    public List<Henkilo> kaikkiHenkilot(String sukunimi) {
        List<Henkilo> sopivat = henkilot.stream()
                .filter(h -> h.getSukunimi().equalsIgnoreCase(sukunimi))
                .collect(Collectors.toList());
        return sopivat;
    }

}
