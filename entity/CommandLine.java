package se.lexicon.MartinKlasson.GolfProject.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.MartinKlasson.GolfProject.repository.PlayerRepository;

/*@Component
public class CommandLine implements CommandLineRunner {

    private PlayerRepository playerRepository;

    @Autowired
    public CommandLine(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Player testPlayer = new Player(
                "Martin",
                "Klasson",
                "tillmartin2000@yahoo.se"
        );
        testPlayer = playerRepository.save(testPlayer);

        System.out.println(playerRepository.findByEmail("tillmartin2000@yahoo.se"));
    }
}*/
