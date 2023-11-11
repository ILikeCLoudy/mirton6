package com.example.demo.repository;

import com.example.demo.domain.RentalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalInfoRepository extends JpaRepository<RentalInfo, Long> {
}
