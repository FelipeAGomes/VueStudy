package com.vehiclemanagement.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.vehiclemanagement.entities.Sales;
import com.vehiclemanagement.entities.User;
import com.vehiclemanagement.entities.Vehicles;
import com.vehiclemanagement.entities.enums.Status;
import com.vehiclemanagement.repositories.SalesRepository;
import com.vehiclemanagement.repositories.UserRepository;
import com.vehiclemanagement.repositories.VehiclesRepository;

@Configuration
public class Test implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VehiclesRepository vehiclesRepository;

	@Autowired
	private SalesRepository salesRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Rogerio", "Gomes", "rogerAuto@gmail.com", "1234");

		Sales sales1 = new Sales(null, 8000.0, Instant.parse("2023-02-20T19:53:07Z"), 5000.0, user1);
		
		Vehicles vehicles1 = new Vehicles(null, "Mercedes", "GLA250", 1500.50, 2000.0, null, Status.TO_SELL, user1, sales1);
		
		userRepository.saveAll(Arrays.asList(user1));
		vehiclesRepository.saveAll(Arrays.asList(vehicles1));
		salesRepository.saveAll(Arrays.asList(sales1));
	}
}
