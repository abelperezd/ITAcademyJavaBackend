package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.services;

import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.model.Sucursal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISucursalService {

    void createSucursal(SucursalDTO sucursal);

    void deleteSucursal(int id);

    SucursalDTO getOneSucursal(int id);

    List<SucursalDTO> getAllSucursal();
}
