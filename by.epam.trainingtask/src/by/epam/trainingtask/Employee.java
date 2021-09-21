package by.epam.trainingtask;

import java.io.Serializable;
import java.util.Objects;

public abstract class Employee implements Serializable {
	
	public static final int MINIMYM_WAGE = 1500;
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String position;
	private int workExperience;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String position, int workExperience) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.workExperience = workExperience;
	}

	public double getIncreasingKoefficient() {
		if (workExperience <= 2) {
			return 1.0;
		} else if (workExperience > 2 && workExperience <= 5) {
			return 1.2;
		} else if (workExperience > 5 && workExperience <= 15) {
			return 1.5;
		} else {
			return 1.7;
		}
	}

	public abstract double getSalary();

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, position, workExperience);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(position, other.position) && workExperience == other.workExperience;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", position=" + position
				+ ", workExperience=" + workExperience + "years]";
	}
}
