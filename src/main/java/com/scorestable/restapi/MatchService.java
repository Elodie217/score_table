package com.scorestable.restapi;

import com.scorestable.restapi.Match;
import com.scorestable.restapi.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public void deleteMatch(Long id) {
        if (matchRepository.existsById(id)) {
            matchRepository.deleteById(id);
        } else {
            throw new RuntimeException("Match not found with id: " + id);
        }
    }
}