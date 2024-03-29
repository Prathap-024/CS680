package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement {
	
	private LinkedList<ApfsElement> child = new LinkedList<ApfsElement>();
	private LinkedList<ApfsFile> fileList = new LinkedList<ApfsFile>();
	private LinkedList<ApfsDirectory> directoryList = new LinkedList<ApfsDirectory>();
	private LinkedList<ApfsLink> linkList = new LinkedList<ApfsLink>();

	public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			LocalDateTime modifiedTime) {
		super(parent, name, 0, creationTime, ownerName, modifiedTime);
		if (parent != null)
			parent.appendChild(this);
	}

	public LinkedList<ApfsElement> getChildren() {
		return this.child;
	}
	
	public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> comparator) {
		Collections.sort(child, comparator);
		return child;
	}

	public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> comparator) {
		LinkedList<ApfsDirectory> directoryList = getSubDirectories();
		Collections.sort(directoryList, comparator);
		return directoryList;
	}

	public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> comparator) {
		LinkedList<ApfsFile> fileList = getFiles();
		Collections.sort(fileList, comparator);
		return fileList;
	}

	public void appendChild(ApfsElement child) {
		this.child.add(child);
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
		for (FSElement e : child) {
			if (e.isFile()) {
				fileList.add((ApfsFile) e);
			}
		}
		return fileList;
	}
	
	public LinkedList<ApfsLink> getLinks() {
		for (FSElement e : getChildren()) {
			if (e.isLink())
				linkList.add((ApfsLink) e);
		}
		return linkList;
	}

	public LinkedList<ApfsDirectory> getSubDirectories() {
		for (FSElement e : child) {
			if (e instanceof ApfsDirectory) {
				directoryList.add((ApfsDirectory) e);
			}
		}
		return directoryList;
	
	}
	
	public int getTotalSize() {
		int totalSize = 0;
		for (FSElement e : child) {
			if (e.isDirectory()) {
				totalSize += ((ApfsDirectory) e).getTotalSize();
			} else {
				totalSize += e.getSize();
			}
		}
		return totalSize;
	}	

}
