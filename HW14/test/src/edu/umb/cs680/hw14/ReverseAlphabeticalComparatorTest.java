package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class ReverseAlphabeticalComparatorTest {

	LocalDateTime localTime = LocalDateTime.now();
	 
	  APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	  ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("Apfs", 500);
	  ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime,"ApfsFile",localTime);
	  ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime,"ApfsFile",localTime);
	  ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime,"ApfsFile",localTime);
	  ApfsFile a = new ApfsFile(applications, "a", 10, localTime,"ApfsFile",localTime);
	  ApfsFile b = new ApfsFile(applications, "b", 15, localTime,"ApfsFile",localTime);
	  ApfsFile c = new ApfsFile(home, "c", 20, localTime,"ApfsFile",localTime);
	  ApfsFile d = new ApfsFile(home, "d", 50, localTime,"ApfsFile",localTime);
	  ApfsFile e = new ApfsFile(code, "e", 10, localTime,"ApfsFile",localTime);
	  ApfsFile f = new ApfsFile(code, "f", 20, localTime,"ApfsFile",localTime);
	  ApfsLink x = new ApfsLink(home, "x", 0, localTime, "MyFile", localTime, applications);
	  ApfsLink y = new ApfsLink(code, "y", 0, localTime,"ApfsFile",localTime,b);

	@Test
	public void getSubDirectories() {
		ApfsDirectory dir = root;
		LinkedList<ApfsDirectory> actual = dir.getSubDirectories((ApfsElement o1, ApfsElement o2) -> 
			 o2.getName().compareTo(o1.getName()));
		ApfsDirectory[] expected = { home, applications };
		assertArrayEquals(expected, actual.toArray());
	}

	@Test
	public void getFiles() {
		ApfsDirectory dir = home;
		LinkedList<ApfsFile> actual = dir.getFiles((ApfsElement o1, ApfsElement o2) -> 
			 o2.getName().compareTo(o1.getName()));
		ApfsFile[] expected = { d, c };
		assertArrayEquals(expected, actual.toArray());
	}
	
	
	  @Test
	  public void GetChildren() {
		 ApfsDirectory dir = home;
		 LinkedList<ApfsElement> actual = dir.getChildren((ApfsElement o1, ApfsElement o2) -> 
		      o2.getName().compareTo(o1.getName()));
		 ApfsElement[] expected = { x,d,code,c  };
		 assertArrayEquals(expected, actual.toArray());
		}


}
