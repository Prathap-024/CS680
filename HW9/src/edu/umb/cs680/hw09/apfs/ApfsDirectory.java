package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;
import java.util.LinkedList;

import edu.umb.cs680.hw09.fs.FSElement;

public class ApfsDirectory extends ApfsElement {
	
	private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();
	private LinkedList<ApfsFile> fileList = new LinkedList<ApfsFile>();
	private LinkedList<ApfsDirectory> directoryList = new LinkedList<ApfsDirectory>();
	private LinkedList<ApfsLink> linkList = new LinkedList<ApfsLink>();

	public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
			String ownerName,LocalDateTime modifiedTime) {
		
		super(parent, name, 0, creationTime, ownerName, modifiedTime);
		if (parent != null)
			parent.appendChild(this);
	}

	public LinkedList<ApfsElement> getChildren() {
		return this.children;
	}

	public void appendChild(ApfsElement child) {
		this.children.add(child);
		child.setParent(this);
	}
	
	public int countChildren() {
		return getChildren().size();
	}

	public boolean isDirectory() {
		return true;
	}

	public boolean isFile() {
		return false;
	}

	public boolean isLink() {
		return false;
	}

	public LinkedList<ApfsFile> getFiles() {
		for (FSElement e : children) {
			if (e instanceof ApfsFile) {
				fileList.add((ApfsFile) e);
			}
		}
		return fileList;
	}
	
	public LinkedList<ApfsLink> getLinks() {
		for (FSElement e : getChildren()) {
			if (e instanceof ApfsLink)
				linkList.add((ApfsLink) e);
		}
		return linkList;
	}

	public LinkedList<ApfsDirectory> getSubDirectories() {
		for (FSElement e : children) {
			if (e instanceof ApfsDirectory) {
				directoryList.add((ApfsDirectory) e);
			}
		}
		return directoryList;
	}

	public int getTotalSize() {
		int totalSize = 0;
		for (FSElement e : children) {
			if (e instanceof ApfsDirectory) {
				totalSize += ((ApfsDirectory) e).getTotalSize();
			} else {
				totalSize += e.getSize();
			}
		}
		return totalSize;
	}

}
