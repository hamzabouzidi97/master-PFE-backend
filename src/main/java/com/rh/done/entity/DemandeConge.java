package com.rh.done.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Builder
@Data @NoArgsConstructor @AllArgsConstructor
public class DemandeConge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private TypeConge typeConge;
    private Date dateDebut;
    private Date dateFin;
    private double duree;
    @OneToOne
    private User demandeur;
    private boolean validerParManager = false;
    private boolean validerParRh = false;
    private boolean refuserParManager;
    private boolean refuserParRh;
    private String commentaire;
}
