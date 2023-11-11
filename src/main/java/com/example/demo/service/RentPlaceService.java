package com.example.demo.service;

import com.example.demo.domain.RentPlace;
import com.example.demo.dto.RentPlaceDTO;
import com.example.demo.repository.RentPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentPlaceService {

    private final RentPlaceRepository rentPlaceRepository;


    public List<RentPlaceDTO.response> viewMap(){
        List<RentPlace> placeList = rentPlaceRepository.findAll();
        List<RentPlaceDTO.response> res = new ArrayList<>();
        placeList.forEach(v->{
            res.add(RentPlaceDTO.response.builder()
                            .id(v.getId())
                            .name(v.getName())
                            .address((v.getAddress()))
                            .xMap(v.getXMap())
                            .yMap(v.getYMap())
                            .numOfRemain(v.getNumOfRemain())
                            .build());
        });
        return res;
    }
}
