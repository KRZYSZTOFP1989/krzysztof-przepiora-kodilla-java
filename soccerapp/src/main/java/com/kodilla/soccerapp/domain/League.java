package com.kodilla.soccerapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity(name = "LEAGUES")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(targetEntity = Team.class,
            mappedBy = "league",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Team> teams = new ArrayList<>();

    public League() {
    }
}
