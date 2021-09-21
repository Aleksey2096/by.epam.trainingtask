package by.epam.trainingtask;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLStaxParser {
	public static List<Employee> parseXMLFile(String fileName) {
		List<Employee> employees = new ArrayList<>();
		Employee employee = null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
			while (reader.hasNext()) {
				XMLEvent xmlEvent = reader.nextEvent();
				if (xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					String startElementName = startElement.getName().getLocalPart();
					if (startElementName.equalsIgnoreCase("Executive")
							|| startElementName.equalsIgnoreCase("ProjectManager")
							|| startElementName.equalsIgnoreCase("Developer")
							|| startElementName.equalsIgnoreCase("Tester")
							|| startElementName.equalsIgnoreCase("Designer")
							|| startElementName.equalsIgnoreCase("SystemAdministrator")) {
						switch (startElementName) {
						case "executive":
							employee = new Executive();
							Attribute executiveSalaryKoefficientAttribute = startElement
									.getAttributeByName(new QName("executiveSalaryKoefficient"));
							if (executiveSalaryKoefficientAttribute != null) {
								((Executive) employee).setExecutiveSalaryKoefficient(
										Double.parseDouble(executiveSalaryKoefficientAttribute.getValue()));
							}
							break;
						case "projectManager":
							employee = new ProjectManager();
							Attribute projectManagerSalaryKoefficientAttribute = startElement
									.getAttributeByName(new QName("projectManagerSalaryKoefficient"));
							if (projectManagerSalaryKoefficientAttribute != null) {
								((ProjectManager) employee).setProjectManagerSalaryKoefficient(
										Double.parseDouble(projectManagerSalaryKoefficientAttribute.getValue()));
							}
							break;
						case "developer":
							employee = new Developer();
							Attribute developerSalaryKoefficientAttribute = startElement
									.getAttributeByName(new QName("developerSalaryKoefficient"));
							if (developerSalaryKoefficientAttribute != null) {
								((Developer) employee).setDeveloperSalaryKoefficient(
										Double.parseDouble(developerSalaryKoefficientAttribute.getValue()));
							}
							break;
						case "tester":
							employee = new Tester();
							Attribute testerSalaryKoefficientAttribute = startElement
									.getAttributeByName(new QName("testerSalaryKoefficient"));
							if (testerSalaryKoefficientAttribute != null) {
								((Tester) employee).setTesterSalaryKoefficient(
										Double.parseDouble(testerSalaryKoefficientAttribute.getValue()));
							}
							break;
						case "designer":
							employee = new Designer();
							Attribute designerSalaryKoefficientAttribute = startElement
									.getAttributeByName(new QName("designerSalaryKoefficient"));
							if (designerSalaryKoefficientAttribute != null) {
								((Designer) employee).setDesignerSalaryKoefficient(
										Double.parseDouble(designerSalaryKoefficientAttribute.getValue()));
							}
							break;
						case "systemAdministrator":
							employee = new SystemAdministrator();
							Attribute systemAdministratorSalaryKoefficientAttribute = startElement
									.getAttributeByName(new QName("systemAdministratorSalaryKoefficient"));
							if (systemAdministratorSalaryKoefficientAttribute != null) {
								((SystemAdministrator) employee).setSystemAdministratorSalaryKoefficient(
										Double.parseDouble(systemAdministratorSalaryKoefficientAttribute.getValue()));
							}
							break;
						}
						Attribute firstNameAttribute = startElement.getAttributeByName(new QName("firstName"));
						if (firstNameAttribute != null) {
							employee.setFirstName(firstNameAttribute.getValue());
						}
						Attribute lastNameAttribute = startElement.getAttributeByName(new QName("lastName"));
						if (lastNameAttribute != null) {
							employee.setLastName(lastNameAttribute.getValue());
						}
						Attribute positionAttribute = startElement.getAttributeByName(new QName("position"));
						if (positionAttribute != null) {
							employee.setPosition(positionAttribute.getValue());
						}
						Attribute workExperienceAttribute = startElement
								.getAttributeByName(new QName("workExperience"));
						if (workExperienceAttribute != null) {
							employee.setWorkExperience(Integer.parseInt(workExperienceAttribute.getValue()));
						}
					}
				}
				if (xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					String endElementName = endElement.getName().getLocalPart();
					if (endElementName.equalsIgnoreCase("Executive")
							|| endElementName.equalsIgnoreCase("ProjectManager")
							|| endElementName.equalsIgnoreCase("Developer") || endElementName.equalsIgnoreCase("Tester")
							|| endElementName.equalsIgnoreCase("Designer")
							|| endElementName.equalsIgnoreCase("SystemAdministrator")) {
						employees.add(employee);
					}
				}
			}
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
		return employees;
	}
}
