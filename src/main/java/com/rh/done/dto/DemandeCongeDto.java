package com.rh.done.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class DemandeCongeDto {

    private Long id;
    //@JsonFormat(pattern="dd-MM-yyyy")
    private Date dateDebut;
    //@JsonFormat(pattern="dd-MM-yyyy")
    private Date dateFin;
    private int duree;
    private int demandeur;
    private boolean validerParManager;
    private boolean validerParRh;
    private boolean refuserParManager;
    private boolean refuserParRh;
    private String commentaire;
    private TypeCongeDto typeCongeDto;
}
