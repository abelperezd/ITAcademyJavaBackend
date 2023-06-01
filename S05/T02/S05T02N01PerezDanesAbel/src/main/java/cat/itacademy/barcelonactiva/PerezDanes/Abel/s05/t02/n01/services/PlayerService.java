package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.services;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto.RollingDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Player;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Rolling;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @Override
    public void createPlayer(PlayerDTO player) {
        try {
            playerRepository.save(DTOToPlayer(player));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deletePlayerById(int id) {
        try {
            playerRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public PlayerDTO getOnePlayerById(int id) {
        Optional<Player> player = playerRepository.findById(id);

        if (player.isPresent()) {
            return PlayerToDTO(player.get());
        } else {
            return null;
        }
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        try {
            List<PlayerDTO> playerDtos = new ArrayList<>();
            List<Player>  players = playerRepository.findAll();
            if(players == null)
                return null;

            players.forEach(p -> {
                playerDtos.add(PlayerToDTO(p));
            });

            if (playerDtos.isEmpty()) {
                return null;
            }
            return playerDtos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    @Override
    public PlayerDTO getOnePlayerByName(String name) {
        Player player = playerRepository.findByName(name);
        if(player == null)
            return null;
        return PlayerToDTO(player);
    }

    @Override
    public PlayerDTO getWorsePlayer(List<PlayerDTO> players){
        if(players == null)
            return new PlayerDTO();
        return players.stream()
                .min((p1, p2) -> Float.compare(p1.getAverageScore(), p2.getAverageScore()))
                .orElse(null);
    }

    @Override
    public PlayerDTO getBestPlayer(List<PlayerDTO> players){
        if(players == null)
            return new PlayerDTO();

        return players.stream()
                .max((p1, p2) -> Float.compare(p1.getAverageScore(), p2.getAverageScore()))
                .orElse(null);
    }

    //region Mappers

    public PlayerDTO PlayerToDTO(Player player) {
        return new PlayerDTO(player.getId(), player.getName(), player.getDate());
    }

    public Player DTOToPlayer(PlayerDTO dto) {
        return new Player(dto.getId(), dto.getName(), dto.getDate());
    }


    //endregion

}
