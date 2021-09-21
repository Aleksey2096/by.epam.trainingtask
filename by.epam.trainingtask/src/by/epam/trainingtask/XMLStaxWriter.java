package by.epam.trainingtask;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XMLStaxWriter {
	public static void writeXMLFile(ProjectTeam pt, String fileName) {
		try {
			XMLOutputFactory output = XMLOutputFactory.newInstance();
			XMLStreamWriter writer = output.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
			writer.writeStartDocument("UTF-8", "1.0");
			writer.writeStartElement("projectTeam");
			writer.writeAttribute("projectPrice", String.valueOf(pt.getPrice()) + "$");
			writer.writeStartElement("employees");
			String commonStartElement = "";
			for (int i = 0; i < pt.getProjectTeamList().size(); i++) {
				if (!commonStartElement
						.equalsIgnoreCase(pt.getProjectTeamList().get(i).getClass().getSimpleName() + "s")) {
					commonStartElement = pt.getProjectTeamList().get(i).getClass().getSimpleName().toLowerCase()
							.charAt(0) + pt.getProjectTeamList().get(i).getClass().getSimpleName().substring(1) + "s";
					writer.writeStartElement(commonStartElement);
				}
				writer.writeStartElement(
						pt.getProjectTeamList().get(i).getClass().getSimpleName().toLowerCase().charAt(0)
								+ pt.getProjectTeamList().get(i).getClass().getSimpleName().substring(1));
				writer.writeAttribute("firstName", pt.getProjectTeamList().get(i).getFirstName());
				writer.writeAttribute("lastName", pt.getProjectTeamList().get(i).getLastName());
				writer.writeAttribute("position", pt.getProjectTeamList().get(i).getPosition());
				writer.writeAttribute("workExperience",
						String.valueOf(pt.getProjectTeamList().get(i).getWorkExperience()));
				if (pt.getProjectTeamList().get(i) instanceof ProjectManager) {
					writer.writeAttribute("projectManagerSalaryKoefficient", String.valueOf(
							((ProjectManager) pt.getProjectTeamList().get(i)).getProjectManagerSalaryKoefficient()));
				} else if (pt.getProjectTeamList().get(i) instanceof Developer) {
					writer.writeAttribute("developerSalaryKoefficient", String
							.valueOf(((Developer) pt.getProjectTeamList().get(i)).getDeveloperSalaryKoefficient()));
				} else if (pt.getProjectTeamList().get(i) instanceof Tester) {
					writer.writeAttribute("testerSalaryKoefficient",
							String.valueOf(((Tester) pt.getProjectTeamList().get(i)).getTesterSalaryKoefficient()));
				} else if (pt.getProjectTeamList().get(i) instanceof Designer) {
					writer.writeAttribute("designerSalaryKoefficient",
							String.valueOf(((Designer) pt.getProjectTeamList().get(i)).getDesignerSalaryKoefficient()));
				} else {
					writer.writeAttribute("developerSalaryKoefficient",
							String.valueOf(((SystemAdministrator) pt.getProjectTeamList().get(i))
									.getSystemAdministratorSalaryKoefficient()));
				}
				writer.writeEndElement();
				if (pt.getProjectTeamList().size() == i + 1 || !pt.getProjectTeamList().get(i).getClass().toString()
						.equals(pt.getProjectTeamList().get(i + 1).getClass().toString())) {
					writer.writeEndElement();
				}
			}
			writer.writeEndElement();
			writer.writeEndElement();
			writer.writeEndDocument();
			writer.flush();
		} catch (XMLStreamException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("XML file is recorded!");
	}
}
