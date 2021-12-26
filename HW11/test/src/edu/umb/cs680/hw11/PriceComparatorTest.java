package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class PriceComparatorTest {
	ArrayList<Car> ListOfCars = new ArrayList<Car>();

	@Test
	public void verifyParetoCompare1() {
		Car car1 = new Car("A", "X3", 2015, 25, 100000);
		Car car2 = new Car("B", "300", 2017, 40, 111000);
		Car car3 = new Car("C", "C300", 2012, 25, 120000);
		ListOfCars.add(car1);
		ListOfCars.add(car2);
		ListOfCars.add(car3);
		for (Car car : ListOfCars) {
			car.setDominationCount(ListOfCars);
		}
		Collections.sort(ListOfCars, new ParetoComparator());

		assertEquals(100000, ListOfCars.get(0).getPrice());
		assertEquals(111000, ListOfCars.get(1).getPrice());
		assertEquals(120000, ListOfCars.get(2).getPrice());
		
	}


}
