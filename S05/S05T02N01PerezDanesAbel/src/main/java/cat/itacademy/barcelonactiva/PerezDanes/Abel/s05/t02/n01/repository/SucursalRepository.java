package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.repository;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

    List<Sucursal> findById(String id);
}
