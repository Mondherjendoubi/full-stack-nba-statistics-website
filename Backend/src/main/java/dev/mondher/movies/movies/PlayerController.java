package dev.mondher.movies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping
    public ResponseEntity<List<Player>> getMovies() {
        return new ResponseEntity<List<Player>>(service.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Player>> getSinglPlayer(@PathVariable String id){
        return new ResponseEntity<Optional<Player>>(service.findPlayerById(id), HttpStatus.OK);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<Player>> getDistinctTeams(@PathVariable int age){
        return new ResponseEntity<List<Player>>(service.findDistinctTeams(age), HttpStatus.OK);
    }

    @GetMapping("/positions/{positions}")
    public ResponseEntity<List<Player>> getDistinctPositions(@PathVariable String positions){
        return new ResponseEntity<List<Player>>(service.findDistinctPositions(positions), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Player>> getSinglePlayerByName(@PathVariable String name) {
        List<Player> player = service.findPlayerByPlayerName(name);

        if (!player.isEmpty()) {
            return new ResponseEntity<List<Player>>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/team/{teamName}")
    public ResponseEntity<List<Player>> getPlayersInBostonTeam(@PathVariable String teamName) {
        List<Player> player = service.getPlayersInBostonTeam(teamName);
        if (!player.isEmpty()) {
            return new ResponseEntity<List<Player>>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/team/{teamName}/pos/{position}/age/{age}")
    public ResponseEntity<List<Player>> getPlayersByParameters(@PathVariable String teamName,@PathVariable String position,@PathVariable int age) {
        List<Player> player = service.findPlayersByParameters(teamName,position,age);
        if (!player.isEmpty()) {
            return new ResponseEntity<List<Player>>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/team/{teamName}/pos/{position}")
    public ResponseEntity<List<Player>> getPlayersWithTeamAndPosition(
            @PathVariable String teamName,
            @PathVariable String position
    ) {
        List<Player> player = service.findPlayersByParameters(teamName,position,0);
        if (!player.isEmpty()) {
            return new ResponseEntity<List<Player>>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/team/{teamName}/age/{age}")
    public ResponseEntity<List<Player>> getPlayersWithTeamAndAge(
            @PathVariable String teamName,
            @PathVariable Integer age
    ) {
        List<Player> player = service.findPlayersByParameters(teamName,"noPos",age);
        if (!player.isEmpty()) {
            return new ResponseEntity<List<Player>>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pos/{position}/age/{age}")
    public ResponseEntity<List<Player>> getPlayersWithTeamAndAge(
            @PathVariable int age,
            @PathVariable String position
    ) {
        List<Player> player = service.findPlayersByParameters("noTeamName",position,age);
        if (!player.isEmpty()) {
            return new ResponseEntity<List<Player>>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/most-assists")
    public ResponseEntity<List<Player>> getPLayerWithMostAssists() {
        return new ResponseEntity<List<Player>>(service.findPlayersWithMaxAssists(), HttpStatus.OK);
    }

    @GetMapping("/most-points")
    public ResponseEntity<List<Player>>getPLayerWithMostPoints() {
        return new ResponseEntity<List<Player>>(service.findPlayersWithPoints(), HttpStatus.OK);
    }

    @GetMapping("/most-rebounds")
    public ResponseEntity<List<Player>> getPlayersWithRebounds() {
        return new ResponseEntity<List<Player>>(service.findPlayersWithRebounds(), HttpStatus.OK);
    }

    @GetMapping("/most-steals")
    public ResponseEntity<List<Player>> getPlayersWithSteals() {
        return new ResponseEntity<List<Player>>(service.findPlayersWithSteals(), HttpStatus.OK);
    }

    @GetMapping("/most-3pt")
    public ResponseEntity<List<Player>> getPlayersWithThreePoints() {
        return new ResponseEntity<List<Player>>(service.findPlayersWithThreePoint(), HttpStatus.OK);
    }

    @GetMapping("/most-2pt")
    public ResponseEntity<List<Player>> getPlayersWithTwoPoint() {
        return new ResponseEntity<List<Player>>(service.findPlayersWithTwoPoint(), HttpStatus.OK);
    }



}
