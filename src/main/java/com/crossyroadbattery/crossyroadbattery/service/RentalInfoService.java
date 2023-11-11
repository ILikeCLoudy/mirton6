package com.crossyroadbattery.crossyroadbattery.service;

import com.crossyroadbattery.crossyroadbattery.domain.RentalInfo;
import com.crossyroadbattery.crossyroadbattery.dto.RentalInfoDTO;
import com.crossyroadbattery.crossyroadbattery.repository.RentalInfoRepository;
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
