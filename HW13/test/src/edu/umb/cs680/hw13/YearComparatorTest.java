package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class YearComparatorTest {

	List<Car> ListOfCars = new ArrayList<Car>();
	@Test
	public void verify_MileageComparator() {
		ListOfCars.add(new Car("AB", "XY", 18, 2015, 10000));
		 ListOfCars.add(new Car("CD", "YZ", 19, 2016, 12000));
		
		 
		 
		 Collections.sort(ListOfCars,(Car car1, Car car2) -> car1.getYear() - car2.getYear());
		 
		 assertEquals(2015, ListOfCars.get(0).getYear());
		 assertEquals(2016, ListOfCars.get(1).getYear());
		 
	}
	@Test
	public void error_MileageComparator() {
		ListOfCars.add(new Car("AB", "XY", 18, 2018, 10000));
		 ListOfCars.add(new Car("CD", "YZ", 19, 2017, 12000));
		
		 
		 
		 Collections.sort(ListOfCars,(Car car1, Car car2) -> car1.getYear() - car2.getYear());
		 
		 assertNotEquals(2019, ListOfCars.get(0).getYear());
		 assertNotEquals(2020, ListOfCars.get(1).getYear());
		 
	}


}
