package dev.mondher.movies.movies;


import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    Optional<Player> findPlayerById(String id);

    List<Player> findPlayerByPlayerName(String playerName);

    List<Player> findDistinctByAge(int age);

    List<Player> findDistinctByPosition(String positions);

    @Aggregation(pipeline = {
            "{$match: {'team': ?0}}"
    })
    List<Player> findPlayerByTeamName(String teamName);

    @Aggregation(pipeline = {
            "{$match: {$and: ["
                    + "{'team': ?0},"
                    + "{'position': {$eq: ?1}},"
                    + "{'age': {$eq: ?2}}"
                    + "]}}"
    })
    List<Player> findPlayersByParameters(String teamName, String position, int age);



}

