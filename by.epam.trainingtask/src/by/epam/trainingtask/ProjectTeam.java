package by.epam.trainingtask;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class ProjectTeam implements Serializable {

	private static final long serialVersionUID = 1L;
	private int price;
	private List<Employee> projectTeamList;

	public ProjectTeam() {
		super();
	}

	public ProjectTeam(int price, List<Employee> projectTeamList) {
		super();
		this.price = price;
		this.projectTeamList = projectTeamList;
	}

	public List<Employee> createTeam(List<Employee> employees) {
		employees.stream();
		int[] inputArr = getProjectInfo();
		switch (inputArr[0]) {
		case 1:
			if (inputArr[1] < 5) {
				price = 85_000;
				return projectTeamList = Stream
						.of(employees.stream().filter(x -> x instanceof ProjectManager).limit(1).toList(),
								employees.stream().filter(x -> x instanceof Developer).limit(5).toList(),
								employees.stream().filter(x -> x instanceof Tester).limit(2).toList(),
								employees.stream().filter(x -> x instanceof Designer).limit(2).toList(),
								employees.stream().filter(x -> x instanceof SystemAdministrator).limit(2).toList())
						.flatMap(List::stream).toList();
			} else {
				price = 70_000;
				return projectTeamList = Stream
						.of(employees.stream().filter(x -> x instanceof ProjectManager).limit(1).toList(),
								employees.stream().filter(x -> x instanceof Developer).limit(3).toList(),
								employees.stream().filter(x -> x instanceof Tester).limit(1).toList(),
								employees.stream().filter(x -> x instanceof Designer).limit(1).toList(),
								employees.stream().filter(x -> x instanceof SystemAdministrator).limit(1).toList())
						.flatMap(List::stream).toList();
			}
		case 2:
			if (inputArr[1] < 8) {
				price = 115_000;
				return projectTeamList = Stream
						.of(employees.stream().filter(x -> x instanceof ProjectManager).limit(1).toList(),
								employees.stream().filter(x -> x instanceof Developer).limit(7).toList(),
								employees.stream().filter(x -> x instanceof Tester).limit(4).toList(),
								employees.stream().filter(x -> x instanceof Designer).limit(3).toList(),
								employees.stream().filter(x -> x instanceof SystemAdministrator).limit(2).toList())
						.flatMap(List::stream).toList();
			} else {
				price = 90_000;
				return projectTeamList = Stream
						.of(employees.stream().filter(x -> x instanceof ProjectManager).limit(1).toList(),
								employees.stream().filter(x -> x instanceof Developer).limit(5).toList(),
								employees.stream().filter(x -> x instanceof Tester).limit(3).toList(),
								employees.stream().filter(x -> x instanceof Designer).limit(2).toList(),
								employees.stream().filter(x -> x instanceof SystemAdministrator).limit(2).toList())
						.flatMap(List::stream).toList();
			}
		case 3:
			if (inputArr[1] < 12) {
				price = 190_000;
				return projectTeamList = Stream
						.of(employees.stream().filter(x -> x instanceof ProjectManager).limit(1).toList(),
								employees.stream().filter(x -> x instanceof Developer).limit(10).toList(),
								employees.stream().filter(x -> x instanceof Tester).limit(5).toList(),
								employees.stream().filter(x -> x instanceof Designer).limit(3).toList(),
								employees.stream().filter(x -> x instanceof SystemAdministrator).limit(3).toList())
						.flatMap(List::stream).toList();
			} else {
				price = 150_000;
				return projectTeamList = Stream
						.of(employees.stream().filter(x -> x instanceof ProjectManager).limit(1).toList(),
								employees.stream().filter(x -> x instanceof Developer).limit(8).toList(),
								employees.stream().filter(x -> x instanceof Tester).limit(4).toList(),
								employees.stream().filter(x -> x instanceof Designer).limit(3).toList(),
								employees.stream().filter(x -> x instanceof SystemAdministrator).limit(2).toList())
						.flatMap(List::stream).toList();
			}
		}
		return projectTeamList;
	}

	public int[] getProjectInfo() {
		int[] inputArr = new int[2];
		Scanner sc = new Scanner(System.in);
		int inputInt;
		do {
			System.out.println("Enter type of the project:\n1 - software development project;"
					+ "\n2 - information systems implementation project;"
					+ "\n3 - infrastructure or organizational project.");
			while (!sc.hasNextInt()) {
				System.out.println("Enter number");
				sc.nextLine();
			}
			inputInt = sc.nextInt();
		} while (inputInt != 1 && inputInt != 2 && inputInt != 3);
		inputArr[0] = inputInt;
		do {
			System.out.println("Enter project completion time in months");
			while (!sc.hasNextInt()) {
				System.out.println("Enter number");
				sc.next();
			}
			inputInt = sc.nextInt();
		} while (inputInt <= 0);
		inputArr[1] = inputInt;
		sc.close();
		return inputArr;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Employee> getProjectTeamList() {
		return projectTeamList;
	}

	public void setProjectTeamList(List<Employee> projectTeamList) {
		this.projectTeamList = projectTeamList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, projectTeamList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectTeam other = (ProjectTeam) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(projectTeamList, other.projectTeamList);
	}

	@Override
	public String toString() {
		return "ProjectTeam [price=" + price + ", projectTeamList=" + projectTeamList + "]";
	}
}
