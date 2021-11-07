package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	Student inState = Student.createInStateStudent("ABC", "boston",20);
	Student outState = Student.createOutStateStudent("ABC", "boston", 20,"NH");
	Student intl = Student.createIntlStudent("ABC", "boston", 123456, "india");

	
	@Test
	void testGetName() {
		assertEquals("ABC", inState.getName());
		assertEquals("ABC", outState.getName());
		assertEquals("ABC", intl.getName());
	}
	
	@Test
	void testGetI20num() {
		assertEquals(0, inState.getI20num());
		assertEquals(0, outState.getI20num());
		assertEquals(123456, intl.getI20num());
		
	}
	
	@Test
	void testGetTution() {
		assertEquals(10000, inState.getTuition());
		assertEquals(15000, outState.getTuition());
		assertEquals(30000, intl.getTuition());
		
	}

	@Test
	void testGetYearsInState() {
		assertEquals(20, inState.getYearsInState());
		assertEquals(20, outState.getYearsInState());
		assertEquals(0, intl.getYearsInState());
	}

	@Test
	void testGetState() {
		assertNull(inState.getState());
		assertEquals("NH",outState.getState());
		assertNull(intl.getState());
	}  
	@Test
	
	void testGetUsAddr() {
		assertEquals("boston", inState.getUsAddress());
		assertEquals("boston", outState.getUsAddress());
		assertEquals("boston", intl.getUsAddress());
	}

	@Test
	void testGetForeignAddress() {
		assertNull(inState.getForeignAddress());
		assertNull(outState.getForeignAddress());
		assertEquals("india", intl.getForeignAddress());
	}
	@Test
	void testCreateInStateStudentName() {
		Student student= Student.createInStateStudent("ABC", "boston",20);
		String name = "ABC";
		assertEquals(name, student.getName());
	}
	
	@Test
	void testCreateInStateStudentTuition() {
		Student student= Student.createInStateStudent("ABC", "boston",20);
		float actual = student.getTuition(); 
		float expected = 10000;
		assertEquals(expected, actual);
	
	}
	
	
	
	@Test
	void testCreateOutStateStudentState() {
		Student stu = Student.createOutStateStudent("ABC", "boston", 20,"NH");
		String exp = "NH";
		assertEquals(exp, stu.getState());
	}
	
	@Test
	void testCreateOutStateStudentTuition() {
		Student stu = Student.createOutStateStudent("ABC", "boston", 20,"NH");
		float act = stu.getTuition(); 
		float exp = 15000;
		assertEquals(exp, act);
	
	}   
	
	@Test
	void testCreateIntlStudentForeignAddress() {
		Student stu = Student.createIntlStudent("ABC", "boston", 123456, "india");
		String addr = "india";
		assertEquals(addr, stu.getForeignAddress());
	}
	
	@Test
	void testCreateIntlStudent() {
		Student stu = Student.createIntlStudent("ABC", "boston", 123456, "india");
		float act = stu.getTuition(); 
		float exp = 30000;
		assertEquals(exp, act);
	}
}
