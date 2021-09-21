package by.epam.trainingtask;

public class Tester extends Employee {

	private static final long serialVersionUID = 1L;
	private double testerSalaryKoefficient;

	public Tester() {
		super();
	}

	public Tester(String firstName, String lastName, String position, int workExperience,
			double testerSalaryKoefficient) {
		super(firstName, lastName, position, workExperience);
		this.testerSalaryKoefficient = testerSalaryKoefficient;
	}

	@Override
	public double getSalary() {
		return testerSalaryKoefficient * MINIMYM_WAGE * getIncreasingKoefficient();
	}

	public double getTesterSalaryKoefficient() {
		return testerSalaryKoefficient;
	}

	public void setTesterSalaryKoefficient(double testerSalaryKoefficient) {
		this.testerSalaryKoefficient = testerSalaryKoefficient;
	}

}
