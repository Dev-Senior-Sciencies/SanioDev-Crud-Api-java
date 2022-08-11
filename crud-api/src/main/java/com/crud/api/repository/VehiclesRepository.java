package com.crud.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.api.model.Vehicles;

@Repository()
public interface VehiclesRepository extends JpaRepository<Vehicles, Long> {
}
