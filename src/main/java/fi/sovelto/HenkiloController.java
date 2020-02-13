package fi.sovelto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/henkilot")
public class HenkiloController {
    private Henkilosto henkilosto;

    public HenkiloController(Henkilosto henkilosto) {
        this.henkilosto = henkilosto;
    }

    @GetMapping("/demo")
    public Henkilo demo() {
        return new Henkilo("Mikki", "Hiiri");
    }
    @GetMapping("")
    public List<Henkilo> kaikki(@RequestParam(name = "sn", required = false) String sukunimi) {
        if (sukunimi != null)
            return henkilosto.kaikkiHenkilot(sukunimi);
        return henkilosto.kaikkiHenkilot();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> haeYksi(@PathVariable int id) {
        Optional<Henkilo> oh = henkilosto.haeIdlla(id);
        if (oh.isPresent()) {
            return ResponseEntity.ok(oh.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<?> luoUusi(@RequestBody Henkilo h) {
        henkilosto.lisaa(h);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(h.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> poista(@PathVariable int id) {
        if (henkilosto.poista(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
