package com.kodilla.soccerapp.service;

import com.kodilla.soccerapp.domain.League;
import com.kodilla.soccerapp.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService  {

    @Autowired
    LeagueRepository leagueRepository;

    public List<League> getAllLeague() {
        return leagueRepository.findAll();
    }

    public Optional<League> getLeagueById(final Long id) {
        return leagueRepository.findById(id);
    }

    public League saveLeague(final League league)  {
        return leagueRepository.save(league);
    }

    public League updateLeague(final League league) {
        return leagueRepository.save(league);
    }

    public void deleteLeague(final Long id) {
        leagueRepository.deleteById(id);
    }
}