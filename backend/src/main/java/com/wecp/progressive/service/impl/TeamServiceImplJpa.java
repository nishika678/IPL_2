package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Team;
import com.wecp.progressive.repository.CricketerRepository;
import com.wecp.progressive.repository.TeamRepository;
import com.wecp.progressive.service.TeamService;

@Service
public class TeamServiceImplJpa implements TeamService
{
    private TeamRepository teamRepository;
    @Autowired
    private CricketerRepository cricketerRepository;

    @Autowired
    public TeamServiceImplJpa(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
        //this.cricketerRepository = cricketerRepository;
    }

    public int addTeam(Team team)
    {
        Team teamObj = teamRepository.save(team);
        return teamObj.getTeamId();
    }

    public void deleteTeam(int teamId)
    { 
        //TeamService.super.deleteTeam(teamId);
        teamRepository.deleteById(teamId);
    }

    public List<Team> getAllTeams()
    {
        return teamRepository.findAll();
    }

    public List<Team> getAllTeamsSortedByName() throws SQLException 
    {
        List<Team> teams = teamRepository.findAll();
        teams.sort(Comparator.comparing(Team::getTeamName));
        return teams;
        
    }

    public Team getTeamById(int teamId)
    {
        return teamRepository.findByTeamId(teamId);
    }

    public void updateTeam(Team team)
    {
        Team teamObj = teamRepository.findById(team.getTeamId()).get();
        teamObj.setTeamName(team.getTeamName());
        teamObj.setOwnerName(team.getOwnerName());
        teamObj.setLocation(team.getLocation());
        teamObj.setEstablishmentYear(team.getEstablishmentYear());
        
        teamRepository.save(teamObj);
    }
    
}