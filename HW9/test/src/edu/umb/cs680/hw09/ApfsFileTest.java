package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.APFS;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;


class ApfsFileTest {
	
	LocalDateTime localTime = LocalDateTime.now();
	APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("Apfs", 500);
    ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime,"ApfsFile",localTime);
    ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime,"ApfsFile",localTime);
	ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime,"ApfsFile",localTime);
	ApfsFile a = new ApfsFile(applications, "a", 15, localTime,"ApfsFile",localTime);
	ApfsFile b = new ApfsFile(applications, "b", 20, localTime,"ApfsFile",localTime);
	ApfsFile c = new ApfsFile(home, "c", 40, localTime,"ApfsFile",localTime);
	ApfsFile d = new ApfsFile(home, "d", 17, localTime,"ApfsFile",localTime);
	ApfsFile e = new ApfsFile(code, "e", 18, localTime,"ApfsFile",localTime);
	ApfsFile f = new ApfsFile(code, "f", 15, localTime,"ApfsFile",localTime);
	ApfsLink x = new ApfsLink(home, "x", 0, localTime, "ApfsFile", localTime, applications);
	ApfsLink y = new ApfsLink(code, "y", 0, localTime,"ApfsFile",localTime,b);
	
	private String[] filetoStringArray(ApfsFile f) {
			String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(),f.getParent().getName(),
					Integer.toString(f.getSize()),f.getCreationTime().toString(),f.getOwnerName(), f.getLastModified().toString() };
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
	public void checkFilesByDirectory() {
		assertSame("a", applications.getFiles().get(0).getName());
		assertSame("b", applications.getFiles().get(1).getName());
		assertSame("c", home.getFiles().get(0).getName());
		assertSame("d", home.getFiles().get(1).getName());
		assertSame("e", code.getFiles().get(0).getName());
		assertSame("f", code.getFiles().get(1).getName());
	}
		
	@Test
	public void checkFileA() {
		String[] expected = { "false", "a", "applications", "15", localTime.toString(), "ApfsFile",localTime.toString() };
		ApfsFile actual = a;
		assertArrayEquals(expected, filetoStringArray(actual));
	}
		
	@Test
	public void  checkFileB() {
		String[] expected = { "false", "b", "applications", "20", localTime.toString(), "ApfsFile",localTime.toString() };
		ApfsFile actual = b;
		assertArrayEquals(expected, filetoStringArray(actual));
		}
		
	@Test
	public void checkFileC() {
		String[] expected = { "false", "c", "home", "40", localTime.toString(), "ApfsFile",localTime.toString() };
		ApfsFile actual = c;
		assertArrayEquals(expected, filetoStringArray(actual));
	}
	@Test
	public void checkFileD() {
		String[] expected = { "false", "d", "home","17", localTime.toString(), "ApfsFile",localTime.toString() };
		ApfsFile actual = d;
		assertArrayEquals(expected, filetoStringArray(actual));
	}
	
	@Test
	public void checkFileE() {
		String[] expected = { "false", "e", "code", "18", localTime.toString(), "ApfsFile", localTime.toString() };
		ApfsFile actual = e;
	    assertArrayEquals(expected, filetoStringArray(actual));
	}
	
	@Test
	public void checkFileF() {
		String[] expected = { "false", "f", "code","15", localTime.toString(), "ApfsFile",localTime.toString() };
		ApfsFile actual = f;
		assertArrayEquals(expected, filetoStringArray(actual));
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
