package se.lexicon.MartinKlasson.GolfProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import se.lexicon.MartinKlasson.GolfProject.dto.PlayerDto;
import se.lexicon.MartinKlasson.GolfProject.dto.UpdateForm;
import se.lexicon.MartinKlasson.GolfProject.entity.Player;
import se.lexicon.MartinKlasson.GolfProject.repository.PlayerRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class PlayerController {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/golf-project")
    public String findPlayers(Model model){
        List<Player> players = (List<Player>) playerRepository.findAll();
        model.addAttribute("playerList", players);
        return "player_control";
    }

    @GetMapping("/golf-project/registration")
    public String getPlayerForm(Model model){
        PlayerDto playerDtoForm = new PlayerDto();
        model.addAttribute("playerForm", playerDtoForm);
        return "player_registration_form";
    }

    @PostMapping("/golf-project/registration")
    public String processForm(@Valid @ModelAttribute("playerForm") PlayerDto playerDtoForm, BindingResult bindingResult){
        if(playerRepository.findByEmail(playerDtoForm.getEmail()).isPresent()){
            FieldError fieldError = new FieldError("playerDtoForm", "email", "Email " + playerDtoForm.getEmail() + " is already registred");
            bindingResult.addError(fieldError);
        }

        if(!playerDtoForm.getPassword().equals(playerDtoForm.getConfirm())){
            FieldError error = new FieldError("playerDtoForm", "confirm", "Passwords do not match!");
            bindingResult.addError(error);
        }

        if(bindingResult.hasErrors()){
            return "/player_registration_form";
        }
        Player player = new Player(
                null,
                playerDtoForm.getRegDate(),
                playerDtoForm.getFirstName(),
                playerDtoForm.getLastName(),
                playerDtoForm.getPassword(),
                playerDtoForm.getEmail(),
                playerDtoForm.getMobileNr(),
                playerDtoForm.getHcp(),
                playerDtoForm.getNrOfRounds()
        );
        player = playerRepository.save(player);
        return "redirect:/golf-project/" + player.getPlayerId();
    }

    @GetMapping("/golf-project/{id}")
    public String findById(@PathVariable("id") String playerId, Model model){
        Player player = playerRepository.findById(playerId).orElseThrow(RuntimeException::new);
        model.addAttribute("player", player);
        return "player_view";

    }

    @PostMapping("/golf-project/{id}/delete")
    public String deleteById(@PathVariable("id") String playerId){
        playerRepository.deleteById(playerId);
        return "redirect:/golf-project";
    }

    @GetMapping("/golf-project/{id}/round-stats")
    public String getStatsPage(@PathVariable("id") String playerId, Model model){
        Player player = playerRepository.findById(playerId).orElseThrow(RuntimeException::new);
        model.addAttribute("player", player);
        return "round_stats";
    }

    @GetMapping("/golf-project/{id}/update")
    public String getUpdateForm(@PathVariable("id") String playerId, Model model){
        Player player = playerRepository.findById(playerId).orElseThrow(RuntimeException::new);

        UpdateForm playerForm = new UpdateForm();
        playerForm.setPlayerId(player.getPlayerId());
        playerForm.setFirstName(player.getFirstName());
        playerForm.setLastName(player.getLastName());
        playerForm.setEmail(player.getEmail());
        playerForm.setMobileNr(player.getMobileNr());
        playerForm.setHcp(player.getHcp());

        model.addAttribute("playerForm", playerForm);
        return "update_form";

    }

    @PostMapping("/golf-project/{id}/update")
    public String processUpdate(@PathVariable("id") String playerId,
                                @Valid @ModelAttribute("playerForm") UpdateForm updateForm,
                                BindingResult bindingResult){
        if(!playerId.equals(updateForm.getPlayerId())){
            throw new RuntimeException();
        }
        Player player = playerRepository.findById(playerId).orElseThrow(RuntimeException::new);
        Optional<Player> tempPlayer = playerRepository.findByEmail(updateForm.getEmail());
        if(tempPlayer.isPresent()){
            if(!player.getPlayerId().equals(tempPlayer.get().getPlayerId())){
                FieldError fieldError = new FieldError("updateForm", "email", "Email already taken!");
                bindingResult.addError(fieldError);
            }
        }
        if(bindingResult.hasErrors()){
            return "update_form";
        }
        player.setFirstName(updateForm.getFirstName());
        player.setLastName(updateForm.getLastName());
        player.setEmail(updateForm.getEmail());
        player.setMobileNr(updateForm.getMobileNr());
        player.setHcp(updateForm.getHcp());

        playerRepository.save(player);

        return "redirect:/golf-project/" + player.getPlayerId();
    }

}
