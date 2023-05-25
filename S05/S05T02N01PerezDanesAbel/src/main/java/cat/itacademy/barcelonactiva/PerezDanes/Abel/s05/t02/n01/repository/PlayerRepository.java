package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.repository;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findById(String id);

     Player findByName(String name);
}
