package fi.sovelto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
