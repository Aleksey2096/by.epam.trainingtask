package by.epam.trainingtask;

import java.util.List;

public class CompanyDemo {
	public static void main(String... strings) {
		List<Employee> employees = XMLStaxParser.parseXMLFile("src/inputFile1.xml");
		ProjectTeam projectTeam = new ProjectTeam();
		projectTeam.createTeam(employees);
		XMLStaxWriter.writeXMLFile(projectTeam, "src/outputFile1.xml");
	}
}
