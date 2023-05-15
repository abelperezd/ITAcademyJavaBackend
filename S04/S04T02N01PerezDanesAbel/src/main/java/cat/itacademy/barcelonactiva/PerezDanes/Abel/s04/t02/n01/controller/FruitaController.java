package cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.controller;


import cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.model.Fruita;
import org.springframework.http.HttpStatus;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.repository.FruitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    FruitaRepository fruitaRepository;

    // http://localhost:8080/fruita/add => post
    @PostMapping("/add")
    public ResponseEntity<Fruita> createFruita(@RequestBody Fruita fruita) {
        try {
            Fruita _fruita = fruitaRepository
                    .save(new Fruita(fruita.getNom(), fruita.getQuantitatQuilos()));
            return new ResponseEntity<>(_fruita, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //http://localhost:8080/fruita/update/{id} => put
    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruita(@PathVariable("id") long id, @RequestBody Fruita fruita) {
        Optional<Fruita> fruitaData = fruitaRepository.findById(id);

        if (fruitaData.isPresent()) {
            Fruita _fruita = fruitaData.get();
            if (!fruita.getNom().isEmpty())
                _fruita.setNom(fruita.getNom());
            if (fruita.getQuantitatQuilos() != 0)
                _fruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
            return new ResponseEntity<>(fruitaRepository.save(_fruita), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //http://localhost:8080/fruita/delete/{id} => delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") long id) {
        try {
            fruitaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllFruitas() {
        try {
            fruitaRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //http://localhost:8080/fruita/getOne/{id}
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getOne(@PathVariable("id") long id) {
        Optional<Fruita> fruitaData = fruitaRepository.findById(id);

        if (fruitaData.isPresent()) {
            return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //http://localhost:8080/fruita/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruitas() {
        try {
            List<Fruita> fruites = new ArrayList<>();

            fruitaRepository.findAll().forEach(fruites::add);

            if (fruites.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruites, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



