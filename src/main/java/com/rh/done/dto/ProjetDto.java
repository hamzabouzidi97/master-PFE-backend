package com.rh.done.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ProjetDto {

    private Long id;
    private String nomProjet;
    private ClientDto client;
}
