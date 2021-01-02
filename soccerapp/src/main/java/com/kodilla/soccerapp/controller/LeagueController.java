package com.kodilla.soccerapp.controller;

import com.kodilla.soccerapp.dto.LeagueDto;
import com.kodilla.soccerapp.exception.NotFoundException;
import com.kodilla.soccerapp.mapper.LeagueMapper;
import com.kodilla.soccerapp.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/")
public class LeagueController {

    @Autowired
    LeagueMapper leagueMapper;
    @Autowired
    LeagueService leagueService;

    @RequestMapping(method = RequestMethod.GET, value = "/league")
    public List<LeagueDto> getLeagues() {
        return leagueMapper.MapToLeagueDtoList(leagueService.getAllLeague());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/league/{leagueId}")
    public LeagueDto getLeague(@PathVariable Long leagueId) throws NotFoundException {
        return leagueMapper.MapToLeagueDto(leagueService.getLeagueById(leagueId).orElseThrow(NotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "league", consumes = APPLICATION_JSON_VALUE)
    public void createLeague(@RequestBody LeagueDto leagueDto) {
        leagueService.saveLeague(leagueMapper.MapToLeague(leagueDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "league")
    public LeagueDto updateLeague(@RequestBody LeagueDto leagueDto) {
        return leagueMapper.MapToLeagueDto(leagueService.updateLeague(leagueMapper.MapToLeague(leagueDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/league/{leagueId}")
    public void deleteLeague(@PathVariable Long leagueId) {
        leagueService.deleteLeague(leagueId);
    }
}
