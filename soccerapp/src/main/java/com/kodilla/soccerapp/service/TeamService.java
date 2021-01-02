package com.kodilla.soccerapp.service;

import com.kodilla.soccerapp.domain.Team;
import com.kodilla.soccerapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(final Long id) {
        return teamRepository.findById(id);
    }

    public Team saveTeam(final Team team)  {
        return teamRepository.save(team);
    }

    public Team updateTeam(final Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(final Long id) {
        teamRepository.deleteById(id);
    }
}
