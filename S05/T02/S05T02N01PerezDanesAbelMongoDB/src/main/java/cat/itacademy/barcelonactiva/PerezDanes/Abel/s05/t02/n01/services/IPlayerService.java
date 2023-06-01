package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.services;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Player;

import java.util.List;

public interface IPlayerService {

    void createPlayer(PlayerDTO player);

    void deletePlayerById(String id);

    PlayerDTO getPlayerById(String id);

    List<PlayerDTO> getAllPlayers();

    PlayerDTO getOnePlayerByName(String name);

    PlayerDTO getWorsePlayer(List<PlayerDTO> players);

    PlayerDTO getBestPlayer(List<PlayerDTO> players);

    PlayerDTO PlayerToDTO(Player player);

    Player DTOToPlayer(PlayerDTO dto);


    void createRolling(String player_id, int number);

    float getAverageUserScoreByUserId(String user_id);

    float getAverageScore();


}
