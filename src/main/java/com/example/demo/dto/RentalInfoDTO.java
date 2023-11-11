package com.example.demo.dto;

import com.example.demo.domain.RentalInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneId;

@Getter
@NoArgsConstructor
public class RentalInfoDTO {
    private Long id;

    private String userEmail;

    private String location;

    private LocalDate startDate;

    private int quantity;


    public RentalInfo toEntity(){
        LocalDate startDate = LocalDate.now(ZoneId.of("Asia/Seoul"));

        return RentalInfo.builder()
                .userEmail(userEmail)
                .location(location)
                .startDate(startDate)
                .quantity(quantity)
                .build();
    }
}