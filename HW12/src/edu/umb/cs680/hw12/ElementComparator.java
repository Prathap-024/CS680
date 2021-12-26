package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ElementComparator implements Comparator<ApfsElement>  {
	
	public int compare(ApfsElement ob1, ApfsElement ob2) {
		return ob1.getOwnerName().compareTo(ob2.getOwnerName());
	}

}
