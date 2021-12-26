package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.APFS;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.fs.FSElement;

class ApfsLinkTest {
	
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
	  ApfsFile e = new ApfsFile(code, "e",18, localTime,"ApfsFile",localTime);
	  ApfsFile f = new ApfsFile(code, "f", 15, localTime,"ApfsFile",localTime);
	  ApfsLink x = new ApfsLink(home, "x", 0, localTime, "ApfsFile", localTime, applications);
	  ApfsLink y = new ApfsLink(code, "y", 0, localTime,"ApfsFile",localTime,b);
	
	  
	  @Test
	  public void checkLink() {
			assertTrue(x.isLink());
			assertTrue(y.isLink());
	  }
	  
	  @Test
	  public void checkLinksInDirectory() {
			assertSame("x", home.getLinks().get(0).getName());
			assertSame("y", code.getLinks().get(0).getName());
	  }
	  
	  @Test
	  public void checkSize() {
			assertEquals(0, x.getSize());
			assertEquals(0,y.getSize());
	  }
	    
	  @Test
	  public void checkLinkX() {
			ApfsDirectory expected = applications;
			FSElement actual = x.getTarget();
			assertSame(expected, actual);
		}
	  
	  @Test
	  public void checkLinkY() {
			ApfsFile expected = b;
			FSElement actual = y.getTarget();
			assertSame(expected, actual);
		}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
