package edu.umb.cs680.hw12;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsElement> {
	
	public int compare(ApfsElement ob1, ApfsElement ob2) {
		return ob1.getName().compareTo(ob2.getName());
	}

}
