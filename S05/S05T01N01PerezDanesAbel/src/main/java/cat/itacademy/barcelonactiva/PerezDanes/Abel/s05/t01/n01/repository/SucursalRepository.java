package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.repository;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

   // List<Sucursal> findByNom(String nom);
    List<Sucursal> findById(String id);
}
