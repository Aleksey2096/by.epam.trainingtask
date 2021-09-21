package by.epam.trainingtask;

public class ProjectManager extends Employee {

	private static final long serialVersionUID = 1L;
	private double projectManagerSalaryKoefficient;

	public ProjectManager() {
		super();
	}

	public ProjectManager(String firstName, String lastName, String position, int workExperience,
			double projectManagerSalaryKoefficient) {
		super(firstName, lastName, position, workExperience);
		this.projectManagerSalaryKoefficient = projectManagerSalaryKoefficient;
	}

	@Override
	public double getSalary() {
		return projectManagerSalaryKoefficient * MINIMYM_WAGE * getIncreasingKoefficient();
	}

	public double getProjectManagerSalaryKoefficient() {
		return projectManagerSalaryKoefficient;
	}

	public void setProjectManagerSalaryKoefficient(double projectManagerSalaryKoefficient) {
		this.projectManagerSalaryKoefficient = projectManagerSalaryKoefficient;
	}

}
