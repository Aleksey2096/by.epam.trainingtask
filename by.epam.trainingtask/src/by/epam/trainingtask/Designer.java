package by.epam.trainingtask;

public class Designer extends Employee {

	private static final long serialVersionUID = 1L;
	private double designerSalaryKoefficient;

	public Designer() {
		super();
	}

	public Designer(String firstName, String lastName, String position, int workExperience,
			double designerSalaryKoefficient) {
		super(firstName, lastName, position, workExperience);
		this.designerSalaryKoefficient = designerSalaryKoefficient;
	}

	@Override
	public double getSalary() {
		return designerSalaryKoefficient * MINIMYM_WAGE * getIncreasingKoefficient();
	}

	public double getDesignerSalaryKoefficient() {
		return designerSalaryKoefficient;
	}

	public void setDesignerSalaryKoefficient(double designerSalaryKoefficient) {
		this.designerSalaryKoefficient = designerSalaryKoefficient;
	}
}
