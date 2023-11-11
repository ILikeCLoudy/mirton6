package com.crossyroadbattery.crossyroadbattery.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;




@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class RentPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private double xMap;
    private double yMap;
    private int remaning;


}
