package demoProject;

import com.opencsv.bean.CsvBindByPosition;

public class Result {

	@CsvBindByPosition(position = 0)
	private String firstName;

	@CsvBindByPosition(position = 1)
	private String lastName;

	@CsvBindByPosition(position = 2)
	private int sNo;

	public Result(String firstName, String lastName, int sNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sNo = sNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	@Override
	public String toString() {
		return "Result [firstName=" + firstName + ", lastName=" + lastName + ", sNo=" + sNo + "]";
	}

}
