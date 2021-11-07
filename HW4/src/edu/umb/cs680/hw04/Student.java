package edu.umb.cs680.hw04;

public class Student {
	private float tuition;
	private int i20num;
	private int yrsInState;
	private String state;
	private String foreignAddr;
	private String name;
	private String usAddr;

	
	private Student(String name, String usAddr, int yrsInState, String state, int i20num, String foreignAddr,
			StudentFactory status) {
		this.name = name;
		this.i20num = i20num;
		this.usAddr = usAddr;
		this.yrsInState = yrsInState;
		this.state = state;
		this.foreignAddr = foreignAddr;
		if (status.equals(StudentFactory.INSTATE))
			this.tuition = 10000;
		else if (status.equals(StudentFactory.OUTSTATE))
			this.tuition = 15000;
		else
			this.tuition = 30000;
		
	}
	
	public float getTuition() {
		return tuition;
	}

	public String getName() {
		return name;
	}

	public int getI20num() {
		return i20num;
	}

	public String getUsAddress() {
		return usAddr;
	}

	public int getYearsInState() {
		return yrsInState;
	}

	public String getState() {
		return state;
	}

	public String getForeignAddress() {
		return foreignAddr;
	}

	public static Student createInStateStudent(String name, String usAddr, int yrsInState) {
		return new Student(name, usAddr, yrsInState , null, 0, null, StudentFactory.INSTATE);
	}

	public static Student createOutStateStudent(String name, String usAddr, int yrsInState,String state) {
		return new Student(name, usAddr, yrsInState, state, 0, null, StudentFactory.OUTSTATE);
	}

	public static Student createIntlStudent(String name, String usAddr, int i20num, String foreignAddr) {
		return new Student(name, usAddr, 0, null, i20num, foreignAddr, StudentFactory.INTL);
	}

	public static void main(String[] args) {
		

		System.out.println("Student class has been implemented successfully");
	}

}
