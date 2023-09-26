package dev.mondher.movies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {



    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PlayerRepository repository;

    public List<Player> findAllMovies() {
        return repository.findAll();
    }
    public Optional<Player> findPlayerById(String playerId) {
        return repository.findPlayerById(playerId);
    }

    public List<Player> findPlayerByPlayerName(String playerName) {
        return repository.findPlayerByPlayerName(playerName);
    }

    public List<Player> getPlayersInBostonTeam(String teamName) {
        return repository.findPlayerByTeamName(teamName);
    }


    public List<Player> findPlayersByParameters(String teamName, String position, int age) {
        Query query = new Query();

        if (!teamName.equals("noTeamName")) {
            query.addCriteria(Criteria.where("team").is(teamName));
        }
        if (!position.equals("noPos")) {
            query.addCriteria(Criteria.where("position").is(position));
        }
        if (age > 0) {
            query.addCriteria(Criteria.where("age").is(age));
        }

        return mongoTemplate.find(query, Player.class);
    }

    public List<Player> findDistinctTeams(int age) {
        return repository.findDistinctByAge(age);
    }

    public List<Player> findDistinctPositions(String positions) {
        return repository.findDistinctByPosition(positions);
    }

    public List<Player> findPlayersWithMaxAssists() {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "assists"));
        query.limit(5);
        List<Player> maxEntity = mongoTemplate.find(query, Player.class);
        return maxEntity;
    }

    public  List<Player> findPlayersWithPoints() {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "points"));
        query.limit(5);
        List<Player> maxEntity = mongoTemplate.find(query, Player.class);
        return maxEntity;
    }

    public  List<Player> findPlayersWithRebounds() {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "totalRebounds"));
        query.limit(5);
        List<Player> maxEntity = mongoTemplate.find(query, Player.class);
        return maxEntity;
    }

    public  List<Player> findPlayersWithSteals() {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "steals"));
        query.limit(5);
        List<Player> maxEntity = mongoTemplate.find(query, Player.class);
        return maxEntity;
    }

    public  List<Player> findPlayersWithThreePoint() {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "threePointersMade"));
        query.limit(5);
        List<Player> maxEntity = mongoTemplate.find(query, Player.class);
        return maxEntity;
    }

    public  List<Player> findPlayersWithTwoPoint() {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "fieldGoalsMade"));
        query.limit(5);
        List<Player> maxEntity = mongoTemplate.find(query, Player.class);
        return maxEntity;
    }


}
