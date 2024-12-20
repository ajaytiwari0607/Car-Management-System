package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	// Adding Additional Feature: Global Search
	@Query("SELECT c FROM Car c WHERE " + "LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
			+ "LOWER(c.model) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " + "CAST(c.year AS string) LIKE %:keyword% OR "
			+ "LOWER(c.color) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
			+ "LOWER(c.fuelType) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Car> searchCars(@Param("Keyword") String keyword);
}
