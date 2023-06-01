package cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t01.n02.Controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// https://youtu.be/9SGDpanrc8U?t=972
// https://www.baeldung.com/spring-pathvariable
@SpringBootApplication
@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld")
    public String saluda(@RequestParam(value = "nom", defaultValue = "UNKNOWN") String nom) {
        return "Hola, " + nom + ". Estàs executant un projecte Maven.";
    }

    @GetMapping(value = {"/HelloWorld2", "/HelloWorld2/{nom}"})
    public String saluda2(@PathVariable(value = "nom", required = false) String nom) {
        nom = nom != null ? nom : "UNKNOWN";
        return "Hola, " + (nom) + ". Estàs executant un projecte Maven.";
    }

}
