package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.services;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Sucursal;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalService implements ISucursalService {

    @Autowired
    private final SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }


    @Override
    public void createSucursal(SucursalDTO sucursal) {
        try {
            sucursalRepository.save(new Sucursal(sucursal.getId(), sucursal.getNomSucursal(), sucursal.getPaisSucursal()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteSucursal(int id) {
        try {
            sucursalRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public SucursalDTO getOneSucursal(int id) {
        Optional<Sucursal> sucursalData = sucursalRepository.findById(id);

        if (sucursalData.isPresent()) {
            return SucursalToDTOSucursal(sucursalData.get());
        } else {
            return null;
        }
    }

    @Override
    public List<SucursalDTO> getAllSucursal() {
        try {
            List<SucursalDTO> sucursals = new ArrayList<>();
            sucursalRepository.findAll().forEach(s -> {
                sucursals.add(SucursalToDTOSucursal(s));
            });

            if (sucursals.isEmpty()) {
                return null;
            }
            return sucursals;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //region Mappers

    private SucursalDTO SucursalToDTOSucursal(Sucursal sucursal) {
        return new SucursalDTO(sucursal.getId(), sucursal.getNomSucursal(), sucursal.getPaisSucursal());
    }

    private Sucursal DTOSucursalToSucursal(SucursalDTO dto) {
        return new Sucursal(dto.getId(), dto.getNomSucursal(), dto.getPaisSucursal());
    }

    //endregion
}
