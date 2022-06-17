package com.rh.done.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String matricule;
    private String nom;
    private String prenom;
    private String societe;
    @Column(unique = true)
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
    @JsonIgnore
    private String password;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE })
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    private boolean actif;
    private Date dateRecrutement;
    private Date dateDemission;
    @OneToMany
    private List<Conjoint> conjoints;
    @OneToMany
    private List<Enfant> enfants;
    /*@OneToMany
    private List<Banque> banques;
    */
    @OneToOne
    private Banque banque;
    private String rib;
    @OneToMany
    private List<Diplome> diplomes;
    private String categoriePaie;
    private String numCnss;

}
