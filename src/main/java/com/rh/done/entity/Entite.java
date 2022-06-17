package com.rh.done.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entite_id")
    private Long id;
    private String code;
    private String nom;
    private Date dateCreation;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "entite_id"),
            inverseJoinColumns = @JoinColumn(name = "employer_id"))
    private List<User> employees;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "responsable_id")
    private Responsable responsable;
    /*@OneToOne
    private User responsable;*/
}
