package com.example.kappaspringexam.repository;

import com.example.kappaspringexam.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamJpaRepository extends JpaRepository<Team, String>{
}
