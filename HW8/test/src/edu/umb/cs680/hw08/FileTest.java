package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class FileTest {

	static LocalDateTime localTime = LocalDateTime.now();
	Directory root = new Directory(null, "root", 0, localTime);
	Directory home = new Directory(root, "home", 0, localTime);
	Directory applications = new Directory(root, "applications", 0, localTime);
	Directory code = new Directory(home, "code", 0, localTime);
    
	File a = new File(applications, "a", 15, localTime);
	File b = new File(applications, "b", 20, localTime);
	File c = new File(home, "c", 40, localTime);
	File d = new File(home, "d", 17, localTime);
	File e = new File(code, "e", 18, localTime);
	File f = new File(code, "f", 15, localTime);
    Link x = new Link(home, "x", 0, localTime, applications);
	Link y = new Link(code, "y", 0, localTime, b);

	private String[] fileToStringArray(File f) {
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(),f.getParent().getName(), Integer.toString(f.getSize()),
				f.getCreationTime().toString(), };
		return fileInfo;
	}
	@Test
	public void checkDirectory() {
		assertFalse(a.isDirectory());
		assertFalse(b.isDirectory());
		assertFalse(c.isDirectory());
		assertFalse(d.isDirectory());
		assertFalse(e.isDirectory());
		assertFalse(f.isDirectory());	
		assertTrue(root.isDirectory());
		assertTrue(home.isDirectory());
		assertTrue(applications.isDirectory());
		assertTrue(code.isDirectory());
		
	}
	

	  @Test public void checkFiles() {
		  assertTrue(a.isFile());
		  assertTrue(b.isFile());
		  assertTrue(c.isFile());
		  assertTrue(d.isFile());
		  assertTrue(e.isFile());
		  assertTrue(f.isFile());	
		  assertFalse(root.isFile());
		  assertFalse(home.isFile());
		  assertFalse(applications.isFile());
		  assertFalse(code.isFile());
	 }
	

	@Test
    public void checkFileA() {
		String[] expected = { "false", "a", "applications","15", localTime.toString(),  };
		File actual = a;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
    public void checkFileB() {
		String[] expected = { "false", "b","applications", "20", localTime.toString() };
		File actual = b;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void verifyFileC() {
		String[] expected = { "false", "c","home", "40", localTime.toString()};
		File actual = c;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileD() {
		
		String[] expected = { "false", "d","home", "17", localTime.toString() };
		File actual = d;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	
	@Test
    public void verifyFileE() {
	
		String[] expected = { "false", "e","code", "18", localTime.toString() };
		File actual = e;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileF() {
		String[] expected = { "false", "f","code","15", localTime.toString()};
		File actual = f;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

}
