package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.services;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.model.Sucursal;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        }
    }

    @Override
    public ResponseEntity<SucursalDTO> updateSucursal(int id, SucursalDTO sucursal) {
        Optional<Sucursal> sucursalData = sucursalRepository.findById(id);

        if (sucursalData.isPresent()) {
            Sucursal _sucursal = sucursalData.get();
            if (!sucursal.getNomSucursal().isEmpty())
                _sucursal.setNomSucursal(sucursal.getNomSucursal());
            if (sucursal.getPaisSucursal().isEmpty())
                _sucursal.setPaisSucursal(sucursal.getPaisSucursal());
            return new ResponseEntity<>(SucursalToDTOSucursal(sucursalRepository.save(_sucursal)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteSucursal(int id) {
        try {
            sucursalRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAllSucursal() {
        try {
            sucursalRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
    //public ResponseEntity<List<SucursalDTO>> getAllSucursal() {
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
