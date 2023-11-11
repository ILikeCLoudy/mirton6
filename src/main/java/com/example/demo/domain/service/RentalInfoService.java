package com.example.demo.domain.service;

import com.example.demo.domain.RentalInfo;
import com.example.demo.domain.dto.RentalInfoDTO;
import com.example.demo.domain.repository.RentalInfoRepository;
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
