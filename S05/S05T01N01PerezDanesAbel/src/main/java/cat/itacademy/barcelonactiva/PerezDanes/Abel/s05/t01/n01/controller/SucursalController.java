package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.controller;


import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.model.Sucursal;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.services.SucursalService;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping("/index")
    public String Home(){
        return "index";
    }


    // http://localhost:8080/sucursal/add => post
    @PostMapping("/add")
    public ResponseEntity<Sucursal> createSucursal(@RequestBody Sucursal sucursal) {
        return sucursalService.createSucursal(sucursal);
    }

    //http://localhost:8080/sucursal/update/{id} => put
    @PutMapping("/update/{id}")
    public ResponseEntity<Sucursal> updateSucursal(@PathVariable("id") int id, @RequestBody Sucursal sucursal) {
        return sucursalService.updateSucursal(id, sucursal);
    }

    //http://localhost:8080/sucursal/delete/{id} => delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteSucursal(@PathVariable("id") int id) {
        return sucursalService.deleteSucursal(id);
    }

    //http://localhost:8080/sucursal/deleteAll => delete
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllSucursal() {
        return sucursalService.deleteAllSucursal();
    }

    //http://localhost:8080/sucursal/getOne/{id} => get
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Sucursal> getOne(@PathVariable("id") int id) {
        return sucursalService.getOne(id);
    }

    //http://localhost:8080/sucursal/getAll => get
    @GetMapping("/getAll")
    public ResponseEntity<List<Sucursal>> getAllSucursal() {
        return sucursalService.getAllSucursal();
    }
}



