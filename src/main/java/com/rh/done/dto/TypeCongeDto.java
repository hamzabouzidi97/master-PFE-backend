package com.rh.done.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data @Builder @ToString
public class TypeCongeDto {

    private Long id;
    private String typeConge;
    private int nombreJour;
    private boolean actif;
    private  int minJour;
    private int maxJour;
}
