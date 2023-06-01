package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.services;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Player;
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
    public void deletePlayerById(String id) {
        try {
            playerRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public PlayerDTO getPlayerById(String id) {
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
            List<Player> players = playerRepository.findAll();

            if (players == null)
                return null;
            else if (players.isEmpty())
                return null;

            players.forEach(p -> {
                playerDtos.add(PlayerToDTO(p));
            });

            return playerDtos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public PlayerDTO getOnePlayerByName(String name) {
        Player player = playerRepository.findByName(name);
        if (player == null)
            return null;
        return PlayerToDTO(player);
    }

    @Override
    public PlayerDTO getWorsePlayer(List<PlayerDTO> players) {
        if (players == null)
            return new PlayerDTO();
        else if (players.isEmpty())
            return new PlayerDTO();
        return players.stream()
                .min((p1, p2) -> Float.compare(p1.getAverageScore(), p2.getAverageScore()))
                .orElse(null);
    }

    @Override
    public PlayerDTO getBestPlayer(List<PlayerDTO> players) {
        if (players == null)
            return new PlayerDTO();
        else if (players.isEmpty())
            return new PlayerDTO();

        return players.stream()
                .max((p1, p2) -> Float.compare(p1.getAverageScore(), p2.getAverageScore()))
                .orElse(null);
    }


    @Override
    public void createRolling(String player_id, int number) {
        Optional<Player> player = playerRepository.findById(player_id);

        if (player.isPresent()) {
            player.get().getNumbers().add(number);
            playerRepository.save(player.get());
        }
    }

    @Override
    public float getAverageUserScoreByUserId(String player_id) {

        Optional<Player> player = playerRepository.findById(player_id);

        if (player.isPresent()) {
            int counter = 0;
            if (player.get().getNumbers() != null) {
                for (int n : player.get().getNumbers()) {
                    counter += n == 7 ? 1 : 0;
                }
            } else return 0;
            return (float) counter / player.get().getNumbers().size() * 100;
        } else {
            return 0;
        }
    }

    @Override
    public float getAverageScore() {
        List<Player> players = playerRepository.findAll();
        int rollings = 0;
        int counter = 0;
        if (!players.isEmpty()) {
            for (Player p : players) {
                if (p.getNumbers() != null) {
                    for (int n : p.getNumbers()) {
                        counter += n == 7 ? 1 : 0;
                        rollings++;
                    }
                } else return 0;
            }
            return (float) counter / rollings * 100;
        } else {
            return 0;
        }
    }


    //region Mappers

    public PlayerDTO PlayerToDTO(Player player) {
        return new PlayerDTO(player.getId(), player.getName(), player.getDate(), player.getNumbers());
    }

    public Player DTOToPlayer(PlayerDTO dto) {
        if (dto.getId().isEmpty())
            return new Player(dto.getName(), dto.getDate(), dto.getNumbers());

        return new Player(dto.getId(), dto.getName(), dto.getDate(), dto.getNumbers());
    }


    //endregion

}
