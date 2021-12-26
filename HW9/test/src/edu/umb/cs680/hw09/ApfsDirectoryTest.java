package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.APFS;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;


class ApfsDirectoryTest {
	
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
	
	
	private String[] dirToStringArray(ApfsDirectory d) {
		String parentName = null;
		ApfsDirectory parent = d.getParent();
		if (parent != null) {
			parentName = parent.getName();
		}
		String[] dirInfo = {parentName, Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()),
				d.getCreationTime().toString(),Integer.toString(d.getTotalSize()), Integer.toString(d.countChildren()), d.getOwnerName(), d.getLastModified().toString()  };
		return dirInfo;
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
	public void checkSize() {
		assertEquals(125, root.getTotalSize());
		assertEquals(90, home.getTotalSize());
		assertEquals(35, applications.getTotalSize());
		assertEquals(33, code.getTotalSize());
		
	}
	
	
	@Test
	public void checkCount() {
		assertEquals(2, root.countChildren());
		assertEquals(2, applications.countChildren());
		assertEquals(4, home.countChildren());
		assertEquals(3, code.countChildren());
	}
	
	@Test
	public void checkGetChildren() {
		assertEquals(applications, root.getChildren().get(1));
		assertEquals(home, root.getChildren().get(0));
		assertEquals(code,home.getChildren().get(0));
		assertEquals(a,applications.getChildren().get(0));
		assertEquals(b,applications.getChildren().get(1));
		assertEquals(code,home.getChildren().get(0));
		assertEquals(c,home.getChildren().get(1));
		assertEquals(d,home.getChildren().get(2));
		assertEquals(e,code.getChildren().get(0));
		assertEquals(f,code.getChildren().get(1));
	}

	@Test
	public void checkFileByDirectory() {
		assertSame("a", applications.getFiles().get(0).getName());
		assertSame("b", applications.getFiles().get(1).getName());
		assertSame("c", home.getFiles().get(0).getName());
		assertSame("d", home.getFiles().get(1).getName());
		assertSame("e", code.getFiles().get(0).getName());
		assertSame("f", code.getFiles().get(1).getName());
	}

	
	@Test
	public void checkSubDirectories() {
		assertSame("home", root.getSubDirectories().get(0).getName());
		assertSame("code",home.getSubDirectories().get(0).getName());
		assertSame("applications",root.getSubDirectories().get(1).getName());

	}
	@Test
	public void checkDirectoryRoot() {
		String[] expected = { null,"true", "root", "0", localTime.toString(),"125", "2", "ApfsFile",localTime.toString() };
		ApfsDirectory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	@Test
	public void checkDirectoryHome() {		
		String[] expected = { "root","true", "home", "0", localTime.toString(), "90", "4", "ApfsFile",localTime.toString() };
		ApfsDirectory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	@Test
	public void checkDirectoryApplications() {
		String[] expected = { "root","true", "applications", "0", localTime.toString(), "35", "2", "ApfsFile",localTime.toString() };
		ApfsDirectory actual = applications;
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	@Test
	public void checkDirectoryCode() {
		
	
		String[] expected = { "home","true", "code", "0", localTime.toString(), "33", "3", "ApfsFile",localTime.toString() };
		ApfsDirectory actual = code;
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
