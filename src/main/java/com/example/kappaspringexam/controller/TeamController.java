package com.example.kappaspringexam.controller;

import com.example.kappaspringexam.model.Team;
import com.example.kappaspringexam.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@AllArgsConstructor

public class TeamController {

    private final TeamService teamService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Team create(@RequestBody Team team) {
        return teamService.create(team);
    }

    @PutMapping("")
    public Team update(@RequestBody Team team) {
        return teamService.update(team);
    }

    @GetMapping("")
    public List<Team> getAll() {
        return teamService.getAll();
    }

    @GetMapping("/{id}")
    public Team getById(@PathVariable String id) {
        return teamService.getById(id);
    }
}
