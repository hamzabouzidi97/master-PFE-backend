package com.rh.done.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Responsable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "responsable_id")
    private User employer;
    @OneToMany(mappedBy = "responsable")
    private List<Entite> entities;

}
