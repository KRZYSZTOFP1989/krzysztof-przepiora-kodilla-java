package com.kodilla.soccerapp.dto;

import com.kodilla.soccerapp.domain.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class TeamDto {

    private Long id;
    private String name;
    private String description;
    private String founded;
    private String ground;
    private Long leagueId;
    private List<Player> players = new ArrayList<>();
}
