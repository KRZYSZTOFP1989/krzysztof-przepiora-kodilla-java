package com.kodilla.soccerapp.dto;

import com.kodilla.soccerapp.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueDto {

    private Long id;
    private String name;
    private String description;
    private List<Team> teams = new ArrayList<>();
}
