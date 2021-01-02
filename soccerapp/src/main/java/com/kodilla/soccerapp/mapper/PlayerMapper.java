package com.kodilla.soccerapp.mapper;

import com.kodilla.soccerapp.domain.Player;
import com.kodilla.soccerapp.dto.PlayerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerMapper {

    public Player MapToPlayer (final PlayerDto playerDto) {
        return new Player(
                playerDto.getId(),
                playerDto.getName(),
                playerDto.getSurname(),
                playerDto.getPosition(),
                playerDto.getDateOfBirth()
        );
    }

    public PlayerDto MapToPlayerDto (final Player player) {
        return new PlayerDto(
                player.getId(),
                player.getName(),
                player.getSurname(),
                player.getPosition(),
                player.getDateOfBirth(),
                player.getTeam().getId()
        );
    }

    public List<PlayerDto> MapToPlayerDtoList (final List<Player> playerList) {
        return playerList.stream()
                .map(t -> new PlayerDto(t.getId(), t.getName(), t.getSurname(), t.getPosition(),
                        t.getDateOfBirth(), t.getTeam().getId()))
                .collect(Collectors.toList());
    }
}
