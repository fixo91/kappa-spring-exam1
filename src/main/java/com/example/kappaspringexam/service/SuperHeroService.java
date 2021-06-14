package com.example.kappaspringexam.service;


import com.example.kappaspringexam.exception.ValidationException;
import com.example.kappaspringexam.model.SuperHero;
import com.example.kappaspringexam.model.Universe;
import com.example.kappaspringexam.repository.SuperHeroJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class SuperHeroService {

    private final SuperHeroJpaRepository superHeroJpaRepository;


    public SuperHero create(SuperHero superHero) {
        validateSuperHero(superHero);
        superHeroJpaRepository.save(superHero);
        return superHero;
    }


    public List<SuperHero> getAll() {
        return superHeroJpaRepository.findAll();

    }

    public SuperHero getById(String id) {
        Optional<SuperHero> optionalSuperHero = superHeroJpaRepository.findById(id);
        if (optionalSuperHero.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optionalSuperHero.get();
    }

    private void validateSuperHero(SuperHero superHero) {
        if (!StringUtils.hasText(superHero.getName())) {
            throw new ValidationException("Missing name");
        }
        if (!superHero.getUniverse().equals(Universe.DC) && !superHero.getUniverse().equals(Universe.MARVEL)) {
            throw new ValidationException("Add meg hogy az Universe DC vagy MARVEL!");
        }
        if (superHero.getUniverse() == null) {
            throw new ValidationException("Hianyzo universe!");
        }
        if (!superHero.getUniverse().equals(superHero.getTeam().getUniverse())) {
            throw new ValidationException("Hibas universe");
        }
    }

    public SuperHero update(SuperHero superHero, String id) {
        return null; //nem volt idom
    }
}
