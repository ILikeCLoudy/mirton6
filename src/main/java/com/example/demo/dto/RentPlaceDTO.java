package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RentPlaceDTO {

    @Builder
    @Data
    public static class response{
        private Long id;
        private String name;
        private String address;
        private double xMap;
        private double yMap;
        private int numOfRemain;
    }

}
