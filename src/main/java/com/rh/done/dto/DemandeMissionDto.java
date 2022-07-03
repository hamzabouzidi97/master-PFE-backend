package com.rh.done.dto;


import com.rh.done.entity.User;
import lombok.*;
import java.util.Date;

@Data @ToString @Builder @NoArgsConstructor @AllArgsConstructor
public class DemandeMissionDto {

    private Long id;
    private UserDto demandeur;
    private Date dateDebut;
    private Date dateFin;
    private int duree;
    private String villeDepart;
    private String villeRetour;
    private ClientDto client;
    private ProjetDto projet;
    private String objetMission;
    private String commentaire;
    private boolean validParManager;
}
