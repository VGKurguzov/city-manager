package com.saxakiil.citymanager.repository;

import com.saxakiil.citymanager.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

    Integer countApartmentsByHouse_Id(Integer houseId);
}
