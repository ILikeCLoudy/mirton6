package com.example.demo.service;

import com.example.demo.domain.RentalInfo;
import com.example.demo.dto.RentalInfoDTO;
import com.example.demo.repository.RentalInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RentalInfoService {
    private final RentalInfoRepository rentalInfoRepository;

    public RentalInfo rentBattery(RentalInfoDTO rentalInfoDTO){
        return rentalInfoRepository.save(rentalInfoDTO.toEntity());
    }
}
