package by.epam.trainingtask;

public class SystemAdministrator extends Employee {

	private static final long serialVersionUID = 1L;
	private double systemAdministratorSalaryKoefficient;

	public SystemAdministrator() {
		super();
	}

	public SystemAdministrator(String firstName, String lastName, String position, int workExperience,
			double systemAdministratorSalaryKoefficient) {
		super(firstName, lastName, position, workExperience);
		this.systemAdministratorSalaryKoefficient = systemAdministratorSalaryKoefficient;
	}

	@Override
	public double getSalary() {
		return systemAdministratorSalaryKoefficient * MINIMYM_WAGE * getIncreasingKoefficient();
	}

	public double getSystemAdministratorSalaryKoefficient() {
		return systemAdministratorSalaryKoefficient;
	}

	public void setSystemAdministratorSalaryKoefficient(double systemAdministratorSalaryKoefficient) {
		this.systemAdministratorSalaryKoefficient = systemAdministratorSalaryKoefficient;
	}

}
