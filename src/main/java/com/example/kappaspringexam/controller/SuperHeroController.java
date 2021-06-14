package com.example.kappaspringexam.controller;

import com.example.kappaspringexam.model.SuperHero;
import com.example.kappaspringexam.service.SuperHeroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/superhero")
@AllArgsConstructor

public class SuperHeroController {


    private final SuperHeroService superHeroService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public SuperHero create(@RequestBody SuperHero superHero) {
        return superHeroService.create(superHero);
    }

    @PutMapping("")
    public SuperHero update(@PathVariable SuperHero superHero, @RequestBody String id) {
        return superHeroService.update(superHero, id);
    }

    @GetMapping("")
    public List<SuperHero> getAll() {
        return superHeroService.getAll();
    }

    @GetMapping("/{id}")
    public SuperHero getById(@PathVariable String id) {
        return superHeroService.getById(id);
    }
}
