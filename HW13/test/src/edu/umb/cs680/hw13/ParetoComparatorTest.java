package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

class ParetoComparatorTest {

	ArrayList<Car> ListOfCars = new ArrayList<Car>();

	@Test
	public void verify_ParetoComparator() {
		ListOfCars.add(new Car("AB", "XY", 18, 2015, 10000));
		ListOfCars.add(new Car("CD", "YZ", 19, 2016, 12000));

		for (Car car : ListOfCars) {
			car.setDominationCount(ListOfCars);
		}

		Collections.sort(ListOfCars, (Car car1, Car car2) -> car1.getDominationCount() - car2.getDominationCount());

		assertEquals(10000, ListOfCars.get(0).getPrice());
		assertEquals(12000, ListOfCars.get(1).getPrice());

	}
	
	@Test
	public void error_ParetoComparator() {
		ListOfCars.add(new Car("AB", "XY", 18, 2015, 10000));
		ListOfCars.add(new Car("CD", "YZ", 19, 2016, 12000));

		for (Car car : ListOfCars) {
			car.setDominationCount(ListOfCars);
		}

		Collections.sort(ListOfCars, (Car car1, Car car2) -> car1.getDominationCount() - car2.getDominationCount());

		assertNotEquals(11000, ListOfCars.get(0).getPrice());
		assertNotEquals(1000, ListOfCars.get(1).getPrice());

	}

}
