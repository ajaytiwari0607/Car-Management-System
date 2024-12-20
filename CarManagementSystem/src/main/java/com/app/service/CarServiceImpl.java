package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.entity.Car;
import com.app.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public Car addCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return carRepository.findAll();
	}

	@Override
	public Car getCarById(Long id) {
		// TODO Auto-generated method stub
		return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Sorry Car Not Found"));
	}

	@Override
	public Car updateCar(Long id, Car carDetails) {
		// TODO Auto-generated method stub
		Car car = getCarById(id);
		car.setPrice(carDetails.getPrice());
		car.setYear(carDetails.getYear());
		car.setName(carDetails.getName());
		car.setModel(carDetails.getModel());
		car.setColor(carDetails.getColor());
		car.setFuelType(carDetails.getFuelType());
		return carRepository.save(car);
	}

	@Override
	public void deleteCar(Long id) {
		// TODO Auto-generated method stub
		carRepository.deleteById(id);

	}

	// Adding Additional Feature: Global Search
	@Override
	public List<Car> searchCars(String keyword) {
		// TODO Auto-generated method stub
		return carRepository.searchCars(keyword);
	}

	// Adding Additional Feature: Pagination and Sorting
	@Override
	public Page<Car> getAllCars(Pageable pageable) {
		// TODO Auto-generated method stub
		return carRepository.findAll(pageable);
	}
}
