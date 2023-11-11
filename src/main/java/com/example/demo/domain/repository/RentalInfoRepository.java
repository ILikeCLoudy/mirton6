package com.example.demo.domain.repository;

import com.example.demo.domain.RentalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalInfoRepository extends JpaRepository<RentalInfo, Long> {
}
