package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;


import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.Test;

class MileageComparatorTest {

	List<Car> ListOfCars = new ArrayList<Car>();
	@Test
	public void verify_MileageComparator() {
		

		 ListOfCars.add(new Car("AB", "XY", 22, 2019, 20000));
		 ListOfCars.add(new Car("CD", "YZ", 21, 2018, 13000));
		 
		 
		 Collections.sort(ListOfCars,(Car car1, Car car2) -> car1.getMileage()-car2.getMileage());
		 
		 
		 assertEquals(21,ListOfCars.get(0).getMileage());
		 assertEquals(22, ListOfCars.get(1).getMileage());
		
	}
	
	@Test
	public void error_MileageComparator() {
		

		 ListOfCars.add(new Car("Maserati", "Ghibli", 22, 2019, 78000));
		 ListOfCars.add(new Car("Ford", "MustangGT", 21, 2018, 34000));
		 
		 
		 Collections.sort(ListOfCars,(Car car1, Car car2) -> car1.getMileage()-car2.getMileage());
		 
		 
		 assertNotEquals(22,ListOfCars.get(0).getMileage());
		 assertNotEquals(21, ListOfCars.get(1).getMileage());
		
	}
}
