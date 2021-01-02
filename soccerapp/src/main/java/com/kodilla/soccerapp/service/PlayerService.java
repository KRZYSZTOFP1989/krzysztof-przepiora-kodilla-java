package com.kodilla.soccerapp.service;

import com.kodilla.soccerapp.domain.Player;
import com.kodilla.soccerapp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayer() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(final Long id) {
        return playerRepository.findById(id);
    }

    public Player savePlayer(final Player player)  {
        return playerRepository.save(player);
    }

    public Player updatePlayer(final Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(final Long id) {
        playerRepository.deleteById(id);
    }
}