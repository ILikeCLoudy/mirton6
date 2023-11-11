package com.example.demo.controller;

import com.example.demo.domain.RentPlace;
import com.example.demo.domain.RentalInfo;
import com.example.demo.dto.RentalInfoDTO;
import com.example.demo.repository.RentPlaceRepository;
import com.example.demo.service.RentalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RentalInfoController {
    @Autowired
    RentalInfoService rentalInfoService;

    @Autowired
    RentPlaceRepository rentPlaceRepository;

    @PostMapping("/api/rent/{placeId}")
    public ResponseEntity rent(@PathVariable Long placeId, @RequestBody RentalInfoDTO rentalInfoDTO){
        RentPlace rentPlace = rentPlaceRepository.findById(placeId).orElse(null);
        if(rentPlace.getNumOfRemain() < rentalInfoDTO.getQuantity()){
            return ResponseEntity.status(null).body("대여 수량이 대여소에 존재하는 배터리 갯수보다 많습니다.");
        }
        RentalInfo rentalInfo = rentalInfoService.rentBattery(rentalInfoDTO);

        return ResponseEntity.status(HttpStatus.OK).body(rentalInfo);
    }

}
