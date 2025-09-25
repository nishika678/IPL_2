package com.wecp.progressive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.repository.MatchRepository;
import com.wecp.progressive.service.MatchService;
import com.wecp.progressive.entity.*;
import java.sql.SQLException;

import java.util.*;

@Service
public class MatchServiceImplJpa implements MatchService
{
    private MatchRepository matchRepository;

    @Autowired
    public MatchServiceImplJpa(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatches() throws SQLException
    {
        // List<Match> matches = new ArrayList<Match>();
        // return matches;
        return null;
    }

    public Match getMatchById(int matchId) throws SQLException
    {
        return (null);
    }

    public Integer addMatch(Match match) throws SQLException
    {
        return null;
    }

    public void updateMatch(Match match) throws SQLException
    {

    }

    public void deleteMatch(int matchId) throws SQLException
    {

    }

    @Override
    public List<Match> getAllMatchesByStatus(String status) throws SQLException 
    {
        return MatchService.super.getAllMatchesByStatus(status);
    }  
}