package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.services;

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
public class SucursalService {

    @Autowired
    private final SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }


    public ResponseEntity<Sucursal> createSucursal(Sucursal sucursal) {
        try {
            Sucursal _sucursal = sucursalRepository
                    .save(new Sucursal(sucursal.getNomSucursal(), sucursal.getPaisSucursal()));
            return new ResponseEntity<>(_sucursal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Sucursal> updateSucursal(int id, Sucursal sucursal) {
        Optional<Sucursal> sucursalData = sucursalRepository.findById(id);

        if (sucursalData.isPresent()) {
            Sucursal _sucursal = sucursalData.get();
            if (!sucursal.getNomSucursal().isEmpty())
                _sucursal.setNomSucursal(sucursal.getNomSucursal());
            if (sucursal.getPaisSucursal().isEmpty())
                _sucursal.setPaisSucursal(sucursal.getPaisSucursal());
            return new ResponseEntity<>(sucursalRepository.save(_sucursal), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteSucursal(int id) {
        try {
            sucursalRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAllSucursal() {
        try {
            sucursalRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<Sucursal> getOne(int id) {
        Optional<Sucursal> sucursalData = sucursalRepository.findById(id);

        if (sucursalData.isPresent()) {
            return new ResponseEntity<>(sucursalData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<List<Sucursal>> getAllSucursal() {
        try {
            List<Sucursal> fruites = new ArrayList<>();

            sucursalRepository.findAll().forEach(fruites::add);

            if (fruites.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruites, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
