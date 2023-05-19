package cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.controller;


import cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.model.Fruita;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.services.FruitaService;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.services.IFruitaService;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    private final IFruitaService fruitaService;

    public FruitaController(FruitaService fruitaService) {
        this.fruitaService = fruitaService;
    }

    // http://localhost:8080/fruita/add => post
    @PostMapping("/add")
    public ResponseEntity<Fruita> createFruita(@RequestBody Fruita fruita) {
        return fruitaService.createFruita(fruita);
    }

    //http://localhost:8080/fruita/update/{id} => put
    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruita(@PathVariable("id") long id, @RequestBody Fruita fruita) {
        return fruitaService.updateFruita(id, fruita);
    }

    //http://localhost:8080/fruita/delete/{id} => delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") long id) {
        return fruitaService.deleteFruita(id);
    }

    //http://localhost:8080/fruita/deleteAll => delete
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllFruitas() {
        return fruitaService.deleteAllFruitas();
    }

    //http://localhost:8080/fruita/getOne/{id} => get
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getOne(@PathVariable("id") long id) {
        return fruitaService.getOne(id);
    }

    //http://localhost:8080/fruita/getAll => get
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruitas() {
        return fruitaService.getAllFruitas();
    }
}




