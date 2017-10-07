import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class xmlParser {
	public static void main(String[] args)
	{
		try
		{
			File inputFile = new File("sampleXML.xml");

			SAXBuilder saxBuilder = new SAXBuilder();

			Document document = saxBuilder.build(inputFile);

			System.out.println("Root element : " + document.getRootElement().getName());

			Element classElement = document.getRootElement();

			List<Element> studentList = classElement.getChildren();
			System.out.println("--------------------");

			for(int temp = 0; temp<studentList.size(); temp++)
			{
				Element student = studentList.get(temp);
				System.out.println("\nCurrent Element : " + student.getName());
				Attribute attribute = stuedent.getAttribute("rollNo");
				System.out.println("Student roll no : " + attribute.getValue());
				Element firstName = student.getChild("firstName");
				System.out.println("First Name : " + firtName.getText());
			}
		}
		catch(JDOMException e)
		{
			e.printStackTrace();
		}
		catch(IOException ioe)
		{
			e.printStackTrace();
		}
	}
}
