package by.epam.trainingtask;

public class Developer extends Employee {

	private static final long serialVersionUID = 1L;
	private double developerSalaryKoefficient;

	public Developer() {
		super();
	}

	public Developer(String firstName, String lastName, String position, int workExperience,
			double developerSalaryKoefficient) {
		super(firstName, lastName, position, workExperience);
		this.developerSalaryKoefficient = developerSalaryKoefficient;
	}

	@Override
	public double getSalary() {
		return developerSalaryKoefficient * MINIMYM_WAGE * getIncreasingKoefficient();
	}

	public double getDeveloperSalaryKoefficient() {
		return developerSalaryKoefficient;
	}

	public void setDeveloperSalaryKoefficient(double developerSalaryKoefficient) {
		this.developerSalaryKoefficient = developerSalaryKoefficient;
	}

}
