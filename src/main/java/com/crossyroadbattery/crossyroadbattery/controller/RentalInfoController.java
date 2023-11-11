package com.crossyroadbattery.crossyroadbattery.controller;

import com.crossyroadbattery.crossyroadbattery.domain.RentPlace;
import com.crossyroadbattery.crossyroadbattery.domain.RentalInfo;
import com.crossyroadbattery.crossyroadbattery.dto.RentalInfoDto;
import com.crossyroadbattery.crossyroadbattery.repository.RentPlaceRepository;
import com.crossyroadbattery.crossyroadbattery.service.RentalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalInfoController {
    @Autowired
    RentalInfoService rentalInfoService;

    @Autowired
    RentPlaceRepository rentPlaceRepository;

    @PostMapping("/api/rent/{placeId}")
    public ResponseEntity rent(@PathVariable Long placeId, @RequestBody RentalInfoDto rentalInfoDTO){
        RentPlace rentPlace = rentPlaceRepository.findById(placeId).orElse(null);
        if(rentPlace.getRemaning() < rentalInfoDTO.getQuantity()){
            return ResponseEntity.status(null).body("대여 수량이 대여소에 존재하는 배터리 갯수보다 많습니다.");
        }
        RentalInfo rentalInfo = rentalInfoService.rentBattery(rentalInfoDTO);

        return ResponseEntity.status(HttpStatus.OK).body(rentalInfo);
    }

}
