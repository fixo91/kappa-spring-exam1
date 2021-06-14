package com.example.kappaspringexam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SuperHero {

    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Universe universe;
    @ManyToOne
    private Team team;
    private Boolean hero;





}
