package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<ApfsElement> {
	
	public int compare(ApfsElement ob1, ApfsElement ob2) {
		return ob2.getName().compareTo(ob1.getName());
	}


}
