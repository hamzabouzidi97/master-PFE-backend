package com.rh.done.entity;

import lombok.Data;

import java.util.List;

@Data
public class Elv {
    private Long id;
    List<Element> elements;
}
