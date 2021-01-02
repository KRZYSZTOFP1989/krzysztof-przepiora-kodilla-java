package com.kodilla.soccerapp.mapper;

import com.kodilla.soccerapp.domain.League;
import com.kodilla.soccerapp.dto.LeagueDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LeagueMapper {

    public League MapToLeague (final LeagueDto leagueDto) {
        return new League(
                leagueDto.getId(),
                leagueDto.getName(),
                leagueDto.getDescription(),
                leagueDto.getTeams());
    }

    public LeagueDto MapToLeagueDto (final League league) {
        return new LeagueDto(
                league.getId(),
                league.getName(),
                league.getDescription(),
                league.getTeams());
    }

    public List<LeagueDto> MapToLeagueDtoList (final List<League> leagueList) {
        return leagueList.stream()
                .map(t -> new LeagueDto(t.getId(), t.getName(), t.getDescription(), t.getTeams()))
                .collect(Collectors.toList());
    }
}
