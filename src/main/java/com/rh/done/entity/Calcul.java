package com.rh.done.entity;

import lombok.Data;

@Data
public class Calcul {
    private Long id;
    private User user;
    private Elf elementFonctionel;
    private Elv elementVariable;
    private Double salaireNet;
}
