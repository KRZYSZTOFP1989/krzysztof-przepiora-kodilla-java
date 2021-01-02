package com.kodilla.soccerapp.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "TEAMS")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String founded;
    private String ground;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "leguae_id")
    private League league;

    @OneToMany(targetEntity = Player.class,
            mappedBy = "team",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Player> players = new ArrayList<>();

    public Team(Long id, String name, String description, String founded, String ground, List<Player> players) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.founded = founded;
        this.ground = ground;
        this.players = players;
    }
}
