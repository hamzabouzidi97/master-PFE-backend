package com.rh.done.dto;

import com.rh.done.entity.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
public class UserDto {

    private  Long id;
    private String matricule;
    private String nom;
    private String prenom;
    private String cin;
    private String sex;
    private String adresse1;
    private String adresse2;
    private Date dateNaissance;
    private String lienNaissance;
    private String nationalite;
    private String situationFamiliale;
    private String tel;
    private String email;
    private String username;
    private Set<Role> roles;
    private boolean actif;
    private Date dateRecrutement;
    private Date dateDemission;
    private List<Conjoint> conjoints;
    private List<Enfant> enfants;
    private Banque banque;
    private String rib;
    private List<Diplome> diplomes;

}
