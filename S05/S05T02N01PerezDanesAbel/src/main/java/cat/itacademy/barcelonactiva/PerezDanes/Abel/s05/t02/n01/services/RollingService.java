package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.services;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto.RollingDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Rolling;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.repository.RollingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RollingService implements IRollingService {

    @Autowired
    private final RollingRepository rollingRepository;

    public RollingService(RollingRepository rollingRepository) {
        this.rollingRepository = rollingRepository;
    }


    @Override
    public void createRolling(RollingDTO dto) {
        try {
            rollingRepository.save(new Rolling(dto.getId(), dto.getPlayer(), dto.getNumber()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    @Transactional
    public void deleteRollingsByPlayerId(int user_id) {
        try {
            rollingRepository.deleteRollingsByPlayerId(user_id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<RollingDTO> getRollingsByUserId(int user_id) {
        List<Rolling> rollings = rollingRepository.getRollingsByPlayerId(user_id);
        List<RollingDTO> dtos = new ArrayList<>();
        if (!rollings.isEmpty()) {
            rollings.forEach(r -> {
                dtos.add(RollingToDTO(r));
            });
            return dtos;
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public float getAverageUserScoreByUserId(int user_id) {
        List<Rolling> rollings = rollingRepository.getRollingsByPlayerId(user_id);
        int counter = 0;
        if (!rollings.isEmpty()) {
            for (Rolling r : rollings) {
                counter += r.getNumber() == 7 ? 1 : 0;
            }
            return (float) counter / rollings.size() * 100;
        } else {
            return 0;
        }
    }

    @Override
    public float getAverageScore() {
        List<Rolling> rollings = rollingRepository.findAll();
        int counter = 0;
        if (!rollings.isEmpty()) {
            for (Rolling r : rollings) {
                counter += r.getNumber() == 7 ? 1 : 0;
            }
            return (float) counter / rollings.size() * 100;
        } else {
            return 0;
        }


    }

    //region Mappers

    private RollingDTO RollingToDTO(Rolling rolling) {
        return new RollingDTO(rolling.getId(), rolling.getPlayer(), rolling.getNumber());
    }

    private Rolling DTOToRolling(RollingDTO dto) {
        return new Rolling(dto.getId(), dto.getPlayer(), dto.getNumber());
    }

    //endregion
}
