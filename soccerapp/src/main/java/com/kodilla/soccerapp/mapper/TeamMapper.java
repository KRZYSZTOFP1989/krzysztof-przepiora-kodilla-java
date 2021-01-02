package com.kodilla.soccerapp.mapper;

import com.kodilla.soccerapp.domain.Team;
import com.kodilla.soccerapp.dto.TeamDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMapper {

    public Team MapToTeam(final TeamDto teamDto) {
        return new Team(
                teamDto.getId(),
                teamDto.getName(),
                teamDto.getDescription(),
                teamDto.getFounded(),
                teamDto.getGround(),
                teamDto.getPlayers());
    }

    public TeamDto MapToTeamDto(final Team team) {
        return new TeamDto(
                team.getId(),
                team.getName(),
                team.getDescription(),
                team.getFounded(),
                team.getGround(),
                team.getLeague().getId(),
                team.getPlayers());
    }

    public List<TeamDto> MapToTeamDtoList(List<Team> teamList) {
        return teamList.stream()
                .map(t -> new TeamDto(t.getId(), t.getName(), t.getDescription(), t.getFounded(),
                        t.getGround(), t.getLeague().getId(), t.getPlayers()))
                .collect(Collectors.toList());
    }
}
