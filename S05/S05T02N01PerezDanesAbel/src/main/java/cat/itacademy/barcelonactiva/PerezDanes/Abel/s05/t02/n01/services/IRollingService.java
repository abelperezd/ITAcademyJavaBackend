package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.services;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto.RollingDTO;

import java.util.List;

public interface IRollingService {

    void createRolling(RollingDTO rolling);

    void deleteRollingsByPlayerId(int id);

    List<RollingDTO> getRollingsByUserId(int id);

    float getAverageUserScoreByUserId(int user_id);

    float getAverageScore();

}
