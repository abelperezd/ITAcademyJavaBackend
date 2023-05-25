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
            List<PlayerDTO> players = new ArrayList<>();
            playerRepository.findAll().forEach(p -> {
                players.add(PlayerToDTO(p));
            });

            if (players.isEmpty()) {
                return null;
            }
            return players;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    @Override
    public PlayerDTO getOnePlayerByName(String name) {
        return PlayerToDTO(playerRepository.findByName(name));
    }

    @Override
    public PlayerDTO getWorsePlayer(List<PlayerDTO> players){
        return players.stream()
                .min((p1, p2) -> Float.compare(p1.getAverageScore(), p2.getAverageScore()))
                .orElse(null);
    }

    @Override
    public PlayerDTO getBestPlayer(List<PlayerDTO> players){
        return players.stream()
                .max((p1, p2) -> Float.compare(p1.getAverageScore(), p2.getAverageScore()))
                .orElse(null);
    }

    //region Mappers

    private PlayerDTO PlayerToDTO(Player player) {
        return new PlayerDTO(player.getId(), player.getName(), player.getDate());
    }

    private Player DTOToPlayer(PlayerDTO dto) {
        return new Player(dto.getId(), dto.getName(), dto.getDate());
    }


    //endregion

}
