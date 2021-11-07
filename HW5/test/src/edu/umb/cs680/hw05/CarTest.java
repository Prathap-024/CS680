package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	private String[] carToStringArray(Car car) {
		String[] car_arr = {car.getMake(), car.getModel(), Integer.toString(car.getYear())};
		return car_arr;
	}
	
	@Test
	void verifyCarEqualityWithMakeModelYear() {
		String[] exp = {"Audi", "Q8", "2019"};
		Car act = new Car("Audi", "Q8", 2019, 1000, 25000);
		assertArrayEquals(exp, carToStringArray(act) );
	}

}
