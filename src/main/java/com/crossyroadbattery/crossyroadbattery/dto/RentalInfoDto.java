package com.crossyroadbattery.crossyroadbattery.dto;

import com.crossyroadbattery.crossyroadbattery.domain.RentalInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneId;

@Getter
@Setter
@AllArgsConstructor
public class RentalInfoDto {
    private Long id;
    private String userEmail;
    private String location;
    private LocalDate startDate;
    private int quantity;
    private int price;

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
