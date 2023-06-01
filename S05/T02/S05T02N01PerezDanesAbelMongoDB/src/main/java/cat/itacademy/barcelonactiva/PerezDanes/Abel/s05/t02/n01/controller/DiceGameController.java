package cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.controller;


import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.model.Rolling;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.services.IPlayerService;
import cat.itacademy.barcelonactiva.PerezDanes.Abel.s05.t02.n01.services.PlayerService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@Controller
@RequestMapping("/diceGame")
public class DiceGameController {

    @Autowired
    private final IPlayerService playerService;

    public DiceGameController(PlayerService playerService) {
        this.playerService = playerService;
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

        player.setDate();
        playerService.createPlayer(player);
        System.out.println("player saved: " + player.toString());
        attributes.addFlashAttribute("success", "Player saved.");
        return "redirect:/diceGame/home";
    }

    //http://localhost:8080/sucursal/update/{id} => put
    @GetMapping("/updatePlayer/{id}")

    public String updatePlayer(@PathVariable("id") String id, Model model, RedirectAttributes attributes) {

        PlayerDTO player = playerService.getPlayerById(id);

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
    public String deletePlayer(@PathVariable("id") String id, RedirectAttributes attributes) {

        if (playerService.getPlayerById(id) == null) {
            attributes.addFlashAttribute("error", "ID not valid.");
        } else
            attributes.addFlashAttribute("success", "Player deleted.");

        playerService.deletePlayerById(id);
        System.out.println("Player deleted. ID: " + id);
        return "redirect:/diceGame/home";
    }

    //http://localhost:8080/sucursal/getOne/{id} => get
    @GetMapping("/getPlayer/{id}")
    public PlayerDTO getPlayer(@PathVariable("id") String id) {
        PlayerDTO player = playerService.getPlayerById(id);
        player.setAverageScore(playerService.getAverageUserScoreByUserId(player.getId()));
        return player;
    }

    //http://localhost:8080/sucursal/getAll => get
    @GetMapping(value = {"/", "", "/home", "/getAll"})
    public String getAllPlayers(Model model) {
        List<PlayerDTO> players = playerService.getAllPlayers();
        if (players != null) {
            if (!players.isEmpty())
                players.forEach(p -> p.setAverageScore(playerService.getAverageUserScoreByUserId(p.getId())));
        }

        float avgScore = playerService.getAverageScore();


        model.addAttribute("title", "Dice game");
        model.addAttribute("players", players);
        model.addAttribute("avg", playerService.getAverageScore());
        model.addAttribute("best", playerService.getBestPlayer(players));
        model.addAttribute("worst", playerService.getWorsePlayer(players));

        return "views/home";
    }

    @GetMapping(value = {"/play/{id}"})
    public String play(@PathVariable("id") String id, PlayerDTO player, DiceResult result, Model model, RedirectAttributes attributes) {

        if (player == null || player.getName() == null || player.getName().isEmpty()) {
            player = playerService.getPlayerById(id);
            if (player == null) {
                System.out.println("Invalid player");
                attributes.addFlashAttribute("error", "Player not valid.");
                return "redirect:/diceGame/home";
            }
        }

        player.setAverageScore(playerService.getAverageUserScoreByUserId(player.getId()));

        List<Rolling> rollings = new ArrayList<>();
        if(player.getNumbers()!= null){
            if (!player.getNumbers().isEmpty())
                player.getNumbers().forEach(n -> rollings.add(new Rolling(n)));
        }


        model.addAttribute("title", "Play");
        model.addAttribute("player", player);
        model.addAttribute("result", result);
        model.addAttribute("rollings", rollings);

        return "views/play";
    }

    @GetMapping(value = {"/saveRolling/{id}"})
    public String saveRolling(@PathVariable("id") String id, Model model, RedirectAttributes attributes) {

        PlayerDTO player = playerService.getPlayerById(id);
        if (player == null) {
            System.out.println("Not valid player");
            attributes.addFlashAttribute("error", "Player not valid.");
            return "redirect:/diceGame/home";
        }
        DiceResult result = new DiceResult();
        result.dice1 = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        result.dice2 = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        result.setResult();
        playerService.createRolling(player.getId(), result.dice1 + result.dice2);

         List<Rolling> rollings = new ArrayList<>();
        player.getNumbers().forEach(n -> rollings.add(new Rolling(n)));

        player.setAverageScore(rollings);

        model.addAttribute("title", "Play");
        model.addAttribute("player", player);
        model.addAttribute("result", result);
        model.addAttribute("rollings", rollings);

        return "views/play";
    }

    @GetMapping(value = {"/getPlayerStatistics/{id}"})
    public String getPlayerStatistics(@PathVariable("id") String id, Model model, RedirectAttributes attributes) {
        PlayerDTO player = playerService.getPlayerById(id);
        if (player == null) {
            System.out.println("Not valid player");
            attributes.addFlashAttribute("error", "Player not valid.");
            return "redirect:/diceGame/home";
        }
        player.setAverageScore(playerService.getAverageUserScoreByUserId(player.getId()));
        List<Rolling> rollings = new ArrayList<>();
        player.getNumbers().forEach(n -> rollings.add(new Rolling(n)));
        model.addAttribute("title", "Player statistics");
        model.addAttribute("player", player);
        model.addAttribute("rollings", rollings);
        return "views/statistics";
    }


    public class DiceResult {
        public int dice1 = 0;
        public int dice2 = 0;
        public String result = "";

        public void setResult() {
            result = dice1 + dice2 == 7 ? "Victory" : "Loss";
        }
    }
}



