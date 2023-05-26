package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.controller;


import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto.RollingDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.services.IPlayerService;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.services.IRollingService;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.services.PlayerService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@Controller
@RequestMapping("/diceGame")
public class DiceGameController {

    @Autowired
    private final IPlayerService playerService;
    @Autowired
    private final IRollingService rollingService;

    public DiceGameController(PlayerService playerService, IRollingService rollingService) {
        this.playerService = playerService;
        this.rollingService = rollingService;
    }

    // http://localhost:8080/sucursal/add => post
    @GetMapping("/addPlayer")
    public String addPlayer(Model model) {

        PlayerDTO player = new PlayerDTO();

        model.addAttribute("title", "Add player");
        model.addAttribute("player", player);

        return "views/addPlayer";
    }

    @PostMapping("/savePlayer")
    public String savePlayer(@Valid @ModelAttribute PlayerDTO player, BindingResult result, Model model, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            model.addAttribute("player", player);
            System.out.println("Errors in the form");
            attributes.addFlashAttribute("error", "Incorrect values to save player.");
            return "views/addPlayer";
        }

        if (playerService.getOnePlayerByName(player.getName()) != null) {
            model.addAttribute("player", player);
            System.out.println("Player already exists.");
            attributes.addFlashAttribute("error", "Player already exists.");
            return "views/addPlayer";
        }

        playerService.createPlayer(player);
        System.out.println("player saved: " + player.toString());
        attributes.addFlashAttribute("success", "Player saved.");
        return "redirect:/diceGame/home";
    }

    //http://localhost:8080/sucursal/update/{id} => put
    @GetMapping("/updatePlayer/{id}")

    public String updatePlayer(@PathVariable("id") int id, Model model, RedirectAttributes attributes) {

        PlayerDTO player = playerService.getOnePlayerById(id);

        if (player == null) {
            System.out.println("ID not valid to edit");
            attributes.addFlashAttribute("error", "ID no valid.");
            return "views/home";
        }

        model.addAttribute("title", "Edit player");
        model.addAttribute("player", player);

        return "views/addPlayer";
    }

    //http://localhost:8080/sucursal/delete/{id} => delete
    @GetMapping("/deletePlayer/{id}")
    public String deletePlayer(@PathVariable("id") int id, RedirectAttributes attributes) {

        if (playerService.getOnePlayerById(id) == null) {
            attributes.addFlashAttribute("error", "ID not valid.");
        } else
            attributes.addFlashAttribute("success", "Player deleted.");

        rollingService.deleteRollingsByPlayerId(id);
        playerService.deletePlayerById(id);
        System.out.println("Player deleted. ID: " + id);
        return "redirect:/diceGame/home";
    }

    //http://localhost:8080/sucursal/getOne/{id} => get
    @GetMapping("/getPlayer/{id}")
    public PlayerDTO getPlayer(@PathVariable("id") int id) {
        PlayerDTO player = playerService.getOnePlayerById(id);
        player.setAverageScore(rollingService.getAverageUserScoreByUserId(player.getId()));
        return player;
    }

    //http://localhost:8080/sucursal/getAll => get
    @GetMapping(value = {"/", "", "/home", "/getAll"})
    public String getAllPlayers(Model model) {
        List<PlayerDTO> players = playerService.getAllPlayers();
        if (players != null)
            players.forEach(p -> p.setAverageScore(rollingService.getAverageUserScoreByUserId(p.getId())));

        model.addAttribute("title", "Dice game");
        model.addAttribute("players", players);
        model.addAttribute("avg", rollingService.getAverageScore());
        model.addAttribute("best", playerService.getBestPlayer(players));
        model.addAttribute("worst", playerService.getWorsePlayer(players));

        return "views/home";
    }

    @GetMapping(value = {"/play/{id}"})
    public String play(@PathVariable("id") int id, PlayerDTO player, DiceResult result, Model model, RedirectAttributes attributes) {

        if (player == null || player.getName() == null || player.getName().isEmpty()) {
            player = playerService.getOnePlayerById(id);
            if (player == null) {
                System.out.println("Invalid player");
                attributes.addFlashAttribute("error", "Player not valid.");
                return "redirect:/diceGame/home";
            }
        }

        player.setAverageScore(rollingService.getAverageUserScoreByUserId(player.getId()));

        List<RollingDTO> rollings = rollingService.getRollingsByUserId(player.getId());

        model.addAttribute("title", "Play");
        model.addAttribute("player", player);
        model.addAttribute("result", result);
        model.addAttribute("rollings", rollings);

        return "views/play";
    }

    @GetMapping(value = {"/saveRolling/{id}"})
    public String saveRolling(@PathVariable("id") int id, Model model, RedirectAttributes attributes) {

        PlayerDTO player = playerService.getOnePlayerById(id);
        if (player == null) {
            System.out.println("Not valid player");
            attributes.addFlashAttribute("error", "Player not valid.");
            return "redirect:/diceGame/home";
        }
        DiceResult result = new DiceResult();
        result.dice1 = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        result.dice2 = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        result.setResult();
        rollingService.createRolling(new RollingDTO(playerService.DTOToPlayer(player), result.dice1 + result.dice2));

        List<RollingDTO> rollings = rollingService.getRollingsByUserId(player.getId());

        model.addAttribute("title", "Play");
        model.addAttribute("player", player);
        model.addAttribute("result", result);
        model.addAttribute("rollings", rollings);

        return "views/play";
    }

    @GetMapping(value = {"/getPlayerStatistics/{id}"})
    public String getPlayerStatistics(@PathVariable("id") int id, Model model, RedirectAttributes attributes) {
        PlayerDTO player = playerService.getOnePlayerById(id);
        if (player == null) {
            System.out.println("Not valid player");
            attributes.addFlashAttribute("error", "Player not valid.");
            return "redirect:/diceGame/home";
        }
        player.setAverageScore(rollingService.getAverageUserScoreByUserId(player.getId()));
        List<RollingDTO> rollings = rollingService.getRollingsByUserId(player.getId());
        model.addAttribute("title", "Player statistics");
        model.addAttribute("player", player);
        model.addAttribute("rollings", rollings);
        return "views/playerStatistics";
    }


    public class DiceResult {
        public int dice1 = 0;
        public int dice2 = 0;
        public String result = "";

        public void setResult() {
            result = dice1 + dice1 == 7 ? "Victory" : "Loss";
        }
    }
}



