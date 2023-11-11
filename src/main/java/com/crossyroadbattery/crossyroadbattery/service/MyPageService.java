package com.crossyroadbattery.crossyroadbattery.service;

import com.crossyroadbattery.crossyroadbattery.domain.RentalInfo;
import com.crossyroadbattery.crossyroadbattery.dto.RentalInfoDto;
import com.crossyroadbattery.crossyroadbattery.repository.RentalInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageService {
    private final RentalInfoRepository rentalInfoRepository;

    @Transactional
    public List<RentalInfoDto> findByUserEmail(String email){
        List<RentalInfo> rentalInfos = rentalInfoRepository.findByUserEmail(email);
        return convertToDto(rentalInfos);
    }

    private List<RentalInfoDto> convertToDto(List<RentalInfo> rentalInfos) {
        List<RentalInfoDto> rentalInfoDtos = new ArrayList<>();
        RentalInfoDto rentalInfoDto;
        for(RentalInfo info : rentalInfos){
            int price = calculatePrice(info);
            rentalInfoDto = new RentalInfoDto(
                    info.getId(),
                    info.getUserEmail(),
                    info.getLocation(),
                    info.getStartDate(),
                    info.getQuantity(),
                    price
            );
            rentalInfoDtos.add(rentalInfoDto);
        }
        return rentalInfoDtos;
    }

    private int calculatePrice(RentalInfo info) {
        int price = 50;
        int days = calculateDays(info.getStartDate());

        return days*info.getQuantity()*price;
    }

    private int calculateDays(LocalDate startDate) {
        if (startDate == null) {
            return 0;
        }

        LocalDate currentDate = LocalDate.now();
        long daysDiff = ChronoUnit.DAYS.between(startDate, currentDate);
        return (int) daysDiff+1;
    }
}
