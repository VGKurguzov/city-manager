package com.saxakiil.citymanager.repository;

import com.saxakiil.citymanager.dto.HouseDto;
import com.saxakiil.citymanager.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

    @Query("SELECT new com.saxakiil.citymanager.dto.HouseDto(h.id, c.name, s.name, h.number) FROM House h " +
            "FULL JOIN Street s ON h.street.id = s.id FULL JOIN City c ON s.city.id = c.id WHERE c.id = ?1")
    List<HouseDto> getHouseDtosByCityId(Integer cityId);

    @Query(value = "SELECT new com.saxakiil.citymanager.dto.HouseDto(h.id, c.name, s.name, h.number) FROM House h " +
            "FULL JOIN Street s ON h.street.id = s.id FULL JOIN City c ON s.city.id = c.id WHERE s.id = ?1")
    List<HouseDto> getHouseDtosByStreetId(Integer streetId);

}
