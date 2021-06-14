package com.example.kappaspringexam.service;

import com.example.kappaspringexam.exception.ValidationException;
import com.example.kappaspringexam.model.Kind;
import com.example.kappaspringexam.model.Team;
import com.example.kappaspringexam.repository.TeamJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor

public class TeamService {

    private final TeamJpaRepository teamJpaRepository;

    public Team create(Team team) {
        validation(team);
        team.setId(UUID.randomUUID().toString());
        return teamJpaRepository.save(team);
    }


    public Team update(Team team) {
        return null;
    }

    public List<Team> getAll() {
        return teamJpaRepository.findAll();

    }

    public Team getById(String id) {
        Optional<Team> optionalTeam = teamJpaRepository.findById(id);
        if (optionalTeam.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optionalTeam.get();
    }


    private void validation(Team team) {
        if (!StringUtils.hasText(team.getName())) {
            throw new ValidationException("Hianyzik a csapatnev!");
        }
        if (team.getUniverse() == null) {
            throw new ValidationException("Adjon meg Universet!");
        }
        if (team.getKind() == null) {
            throw new ValidationException("Adjon meg Kind-ot!");
        }
        if (!team.getKind().equals(Kind.VILLAIN) && !team.getKind().equals(Kind.HERO)) {
            throw new ValidationException("Add meg hogy a Team VILLAIN vagy HERO!");
        }
    }
}

