package com.rh.done.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class ClientDto {

    private Long id;
    private String nomClient;
    //private List<ProjetDto> projets;
}
