package com.rh.done.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class DemandeMission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User demandeur;
    private Date dateDebut;
    private Date dateFin;
    private int duree;
    private String villeDepart;
    private String villeRetour;
//    @OneToOne
//    private Client client;
    @OneToOne
    private Projet projet;
    private String objetMission;
    private String commentaire;
    private boolean validParManager;


}
