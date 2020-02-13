package fi.sovelto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class HarjoitusRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HarjoitusRestApplication.class, args);
    }

    @Bean
    public CommandLineRunner alustaHenkilosto(Henkilosto henkilosto) {
        return args -> {
            henkilosto.lisaaKaikki(Arrays.asList(
                    new Henkilo("Aku", "Ankka", LocalDate.parse("1954-03-13")),
                    new Henkilo("Iines", "Ankka", LocalDate.parse("1958-04-26")),
                    new Henkilo("Mikki", "Hiiri", LocalDate.parse("1916-06-07")),
                    new Henkilo("Captain", "America", LocalDate.parse("1923-07-04"))
            ));
        };
    }
}
