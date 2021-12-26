package edu.umb.cs680.hw12;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<ApfsElement> {
	
	public int compare(ApfsElement ob1, ApfsElement ob2) {
		return ob2.getLastModified().compareTo(ob1.getLastModified());
	}


}
