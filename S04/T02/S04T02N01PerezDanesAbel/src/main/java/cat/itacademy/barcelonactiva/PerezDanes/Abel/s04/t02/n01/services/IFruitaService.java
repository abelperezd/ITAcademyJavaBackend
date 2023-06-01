package cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.services;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.model.Fruita;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IFruitaService {

    ResponseEntity<Fruita> createFruita(Fruita fruita);

    ResponseEntity<Fruita> updateFruita( long id, Fruita fruita);

    ResponseEntity<HttpStatus> deleteFruita(long id);

    ResponseEntity<HttpStatus> deleteAllFruitas();

    ResponseEntity<Fruita> getOne(long id);

    ResponseEntity<List<Fruita>> getAllFruitas();

}
