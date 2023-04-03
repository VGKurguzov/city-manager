package com.saxakiil.citymanager.repository;

import com.saxakiil.citymanager.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street, Integer> {

    List<Street> getStreetsByCity_Id(Integer cityId);
}
