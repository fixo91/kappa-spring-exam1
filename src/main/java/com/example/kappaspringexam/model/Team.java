package com.example.kappaspringexam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams")


public class Team {

    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Universe universe;
    @Enumerated(EnumType.STRING)
    private Kind kind;
}
