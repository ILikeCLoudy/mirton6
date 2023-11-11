package com.example.demo.controller;

import com.example.demo.dto.RentPlaceDTO;
import com.example.demo.service.RentPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentPlaceController {

    @Autowired
    RentPlaceService rentPlaceService;
    
    @GetMapping("/api/view-map")
    public ResponseEntity viewMap(){
        List<RentPlaceDTO.response> responses = rentPlaceService.viewMap();
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }


}
