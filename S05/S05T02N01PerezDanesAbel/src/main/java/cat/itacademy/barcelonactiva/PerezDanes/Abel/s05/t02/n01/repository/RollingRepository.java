package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.repository;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Rolling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RollingRepository extends JpaRepository<Rolling, Integer> {

    @Modifying
    @Query("DELETE FROM Rolling r WHERE r.player.id = :id")
    void deleteRollingsByPlayerId(@Param("id") int id);

    @Query("SELECT r FROM Rolling r WHERE r.player.id = :id")
    List<Rolling> getRollingsByPlayerId(@Param("id") int id);

    List<Rolling> findAll();


}
