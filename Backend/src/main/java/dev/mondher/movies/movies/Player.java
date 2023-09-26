package dev.mondher.movies.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "players")
@Data
public class Player {
    @Id
    private String id;

    @Field("PName")
    private String playerName;

    @Field("POS")
    private String position;

    @Field("Team")
    private String team;

    @Field("Age")
    private int age;

    @Field("GP")
    private int gamesPlayed;

    @Field("W")
    private int wins;

    @Field("L")
    private int losses;

    @Field("Min")
    private double minutes;

    @Field("PTS")
    private int points;

    @Field("FGM")
    private int fieldGoalsMade;

    @Field("FGA")
    private int fieldGoalsAttempted;

    @Field("FG%")
    private double fieldGoalPercentage;

    @Field("3PM")
    private int threePointersMade;

    @Field("3PA")
    private int threePointersAttempted;

    @Field("3P%")
    private double threePointPercentage;

    @Field("FTM")
    private int freeThrowsMade;

    @Field("FTA")
    private int freeThrowsAttempted;

    @Field("FT%")
    private double freeThrowPercentage;

    @Field("OREB")
    private int offensiveRebounds;

    @Field("DREB")
    private int defensiveRebounds;

    @Field("REB")
    private int totalRebounds;

    @Field("AST")
    private int assists;

    @Field("TOV")
    private int turnovers;

    @Field("STL")
    private int steals;

}
