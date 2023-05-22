package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.controller;


import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.services.ISucursalService;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t01.n01.services.SucursalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Console;
import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private final ISucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping()
    public String Home(){
        return "home";
    }

    // http://localhost:8080/sucursal/add => post
    @GetMapping("/add")
    public String createSucursal(Model model) {

        SucursalDTO sucursal = new SucursalDTO();

        model.addAttribute("title", "Afegir sucursal");
        model.addAttribute("sucursal", sucursal);

        return "views/add";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute SucursalDTO sucursal, BindingResult result, Model model, RedirectAttributes attributes){

        if(result.hasErrors()){
            model.addAttribute("sucursal", sucursal);
            System.out.println("Errors in the form");
            attributes.addFlashAttribute("error", "Valors incorrectes.");
            return "views/add";
        }

        sucursalService.createSucursal(sucursal);
        System.out.println("Sucursal saved: " + sucursal.toString());
        attributes.addFlashAttribute("success", "Sucursal guardada correctament.");
        return "redirect:/sucursal/getAll";
    }

    //http://localhost:8080/sucursal/update/{id} => put
    @GetMapping("/update/{id}")

    public String updateSucursal(@PathVariable("id") int id, Model model, RedirectAttributes attributes) {

        SucursalDTO sucursal = sucursalService.getOneSucursal(id);


        if(sucursal == null){
            System.out.println("ID not valid to edit");
            attributes.addFlashAttribute("error", "ID no valid.");
            return "views/getAll";
        }

        model.addAttribute("title", "Editar sucursal");
        model.addAttribute("sucursal", sucursal);
        //model.addAttribute("sucursals", sucursals);

        return "views/add";
    }

    //http://localhost:8080/sucursal/delete/{id} => delete
    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable("id") int id, RedirectAttributes attributes) {

        if(sucursalService.getOneSucursal(id) == null){
            attributes.addFlashAttribute("error", "ID no valid.");
        }
        else
            attributes.addFlashAttribute("success", "Sucursal eliminada correctament.");

        sucursalService.deleteSucursal(id);
        System.out.println("User removed. ID: " + id);
        return "redirect:/sucursal/getAll";
    }

    //http://localhost:8080/sucursal/getOne/{id} => get
    @GetMapping("/getOne/{id}")
    public SucursalDTO getOne(@PathVariable("id") int id) {
        return sucursalService.getOneSucursal(id);
    }

    //http://localhost:8080/sucursal/getAll => get
    @GetMapping("/getAll")
    public String getAllSucursal(Model model) {
        model.addAttribute("title","Llista de sucursals");
        model.addAttribute("sucursals",sucursalService.getAllSucursal());
        return "views/getAll";
    }
}



