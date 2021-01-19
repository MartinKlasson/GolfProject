package se.lexicon.MartinKlasson.GolfProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.lexicon.MartinKlasson.GolfProject.entity.Player;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, String> {

    Optional<Player> findByEmail(String email);

}
