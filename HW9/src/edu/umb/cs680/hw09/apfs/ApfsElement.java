package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw09.fs.FSElement;

public abstract class ApfsElement extends FSElement {
	
	private String ownerName;
	private LocalDateTime lastModified;
	
	public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			LocalDateTime lastModified) {
		super(parent, name, size, creationTime);
		this.ownerName = ownerName;
		this.lastModified = lastModified;
	}
	
	public String getOwnerName() {
		return ownerName;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	@Override
	public boolean isDirectory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLink() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFile() {
		// TODO Auto-generated method stub
		return false;
	}

}
