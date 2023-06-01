package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.repository;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    Optional<Player> findById(String id);

    @Query("{name:'?0'}")
    Player findByName(String name);

}
