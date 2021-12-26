package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.Test;

class PriceComparatorTest {

	List<Car> ListOfCars = new ArrayList<Car>();
	@Test
	public void verify_MileageComparator() {
		
		 ListOfCars.add(new Car("AB", "XY", 21, 2018, 44000));
		 ListOfCars.add(new Car("CD", "YZ", 22, 2019, 70000));
		 
		 
		 Collections.sort(ListOfCars,(Car car1, Car car2) -> (int) (car1.getPrice() - car2.getPrice()));
		 
		 
		 assertEquals(44000,ListOfCars.get(0).getPrice());
		 assertEquals(70000, ListOfCars.get(1).getPrice());
	}
	@Test
	public void error_MileageComparator() {
		
		 ListOfCars.add(new Car("AB", "XY", 21, 2018, 44000));
		 ListOfCars.add(new Car("CD", "YZ", 22, 2019, 70000));
		 
		 
		 Collections.sort(ListOfCars,(Car car1, Car car2) -> (int) (car1.getPrice() - car2.getPrice()));
		 
		 
		 assertNotEquals(400,ListOfCars.get(0).getPrice());
		 assertNotEquals(7000, ListOfCars.get(1).getPrice());
	}

}
