package cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.repository;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s04.t02.n01.model.Fruita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitaRepository extends JpaRepository<Fruita, Long> {

    List<Fruita> findByNom(String nom);
    List<Fruita> findById(String id);
}
