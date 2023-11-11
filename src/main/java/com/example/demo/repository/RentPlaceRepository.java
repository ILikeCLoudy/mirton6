package com.example.demo.repository;

import com.example.demo.domain.RentPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentPlaceRepository extends JpaRepository<RentPlace, Long> {
}
