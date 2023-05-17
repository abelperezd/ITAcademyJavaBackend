package cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.services;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.model.Fruita;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FruitaService {

    @Autowired
    private final FruitaRepository fruitaRepository;

    public FruitaService(FruitaRepository fruitaRepository) {
        this.fruitaRepository = fruitaRepository;
    }

    public ResponseEntity<Fruita> createFruita(Fruita fruita) {
        try {
            Fruita _fruita = fruitaRepository
                    .save(new Fruita(fruita.getNom(), fruita.getQuantitatQuilos()));
            return new ResponseEntity<>(_fruita, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Fruita> updateFruita( long id, Fruita fruita) {
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

    public ResponseEntity<HttpStatus> deleteFruita(long id) {
        try {
            fruitaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllFruitas() {
        try {
            fruitaRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<Fruita> getOne(long id) {
        Optional<Fruita> fruitaData = fruitaRepository.findById(id);

        if (fruitaData.isPresent()) {
            return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


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
