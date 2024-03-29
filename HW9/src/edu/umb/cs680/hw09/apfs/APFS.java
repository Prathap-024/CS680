package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw09.fs.FSElement;
import edu.umb.cs680.hw09.fs.FileSystem;

public class APFS extends FileSystem{
	
	private static APFS instance = null;
	private ApfsDirectory root;
	

	public static APFS getAPFSFileSystem() {
		if (instance == null)
			instance = new APFS();
		return instance;
	}
	
	protected FSElement createDefaultRoot() {
		LocalDateTime localTime = LocalDateTime.now();
		root = new ApfsDirectory(null, "root", 0, localTime, "ApfsFile", localTime);
		return root;
	}
	
	public ApfsDirectory getRootDir() {
		return root;
	}

}
