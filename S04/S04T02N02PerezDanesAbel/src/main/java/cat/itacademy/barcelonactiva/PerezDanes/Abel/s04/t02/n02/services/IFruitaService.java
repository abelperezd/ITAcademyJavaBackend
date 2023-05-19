package cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n02.services;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n02.model.Fruita;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFruitaService {

    ResponseEntity<Fruita> createFruita(Fruita fruita);

    ResponseEntity<Fruita> updateFruita( long id, Fruita fruita);

    ResponseEntity<HttpStatus> deleteFruita(long id);

    ResponseEntity<HttpStatus> deleteAllFruitas();

    ResponseEntity<Fruita> getOne(long id);

    ResponseEntity<List<Fruita>> getAllFruitas();

}
