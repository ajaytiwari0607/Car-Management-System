package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Car;
import com.app.service.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping
	public ResponseEntity<Car> addCar(@Valid @RequestBody Car car) {
		return ResponseEntity.ok(carService.addCar(car));
	}

	@GetMapping
	public ResponseEntity<List<Car>> getAllCars() {
		return ResponseEntity.ok(carService.getAllCars());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable Long id) {
		return ResponseEntity.ok(carService.getCarById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable Long id, @Valid @RequestBody Car car) {
		return ResponseEntity.ok(carService.updateCar(id, car));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
		carService.deleteCar(id);
		return ResponseEntity.noContent().build();
	}

	// Adding Additional Feature: Global Search
	@GetMapping("/search")
	public ResponseEntity<List<Car>> searchCars(@RequestParam String Keyword) {
		return ResponseEntity.ok(carService.searchCars(Keyword));
	}

	// Adding Additional Feature: Pagination and Sorting
	@GetMapping("/paginated")
	public ResponseEntity<Page<Car>> getAllCarsPaginated(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		return ResponseEntity.ok(carService.getAllCars(pageable));
	}
}
