package com.rh.done.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Conge {

    private Long id;
    private String typeConge;
    private Date dateDebut;
    private Date dateFin;
    private User demandeur;
    private String commentaire;
    private int duree;

}
