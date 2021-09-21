package by.epam.trainingtask;

public class Executive extends Employee {

	private static final long serialVersionUID = 1L;
	private double executiveSalaryKoefficient;

	public Executive() {
		super();
	}

	public Executive(String firstName, String lastName, String position, int workExperience,
			double executiveSalaryKoefficient) {
		super(firstName, lastName, position, workExperience);
		this.executiveSalaryKoefficient = executiveSalaryKoefficient;
	}

	@Override
	public double getSalary() {
		return executiveSalaryKoefficient * MINIMYM_WAGE * getIncreasingKoefficient();
	}

	public double getExecutiveSalaryKoefficient() {
		return executiveSalaryKoefficient;
	}

	public void setExecutiveSalaryKoefficient(double executiveSalaryKoefficient) {
		this.executiveSalaryKoefficient = executiveSalaryKoefficient;
	}

}
