package com.example.kappaspringexam.repository;

import com.example.kappaspringexam.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroJpaRepository extends JpaRepository<SuperHero, String> {
}
