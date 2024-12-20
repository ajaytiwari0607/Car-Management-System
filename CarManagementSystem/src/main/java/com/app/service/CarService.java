package com.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.entity.Car;

public interface CarService {
	Car addCar(Car car);

	List<Car> getAllCars();

	Car getCarById(Long id);

	Car updateCar(Long id, Car car);

	void deleteCar(Long id);

	// Adding Additional Feature: Global Search
	List<Car> searchCars(String keyword);

	// Adding Additional Feature: Pagination and Sorting
	Page<Car> getAllCars(Pageable pageable);
}
