package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.example.dao.jdbc.ICountriesDAO;
import org.example.models.Student;
import org.example.models.Students;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Logger LOGGER = Logger.getLogger(Main.class);

    private static final String FILENAME = "src/main/resources/XML/Student.xml";

    public static void main(String[] args) throws JAXBException, IOException {
        BasicConfigurator.configure();

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            LOGGER.info("Root Element :" + doc.getDocumentElement().getNodeName());

            NodeList list = doc.getElementsByTagName("student");

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                LOGGER.info("\nCurrent Element :" + node.getNodeName());


                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String firstName = element.getElementsByTagName("studentFirstName").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("studentLastName").item(0).getTextContent();
                    LOGGER.info("First Name : " + firstName);
                    LOGGER.info("Last Name : " + lastName);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        //JAXB MARSHAL TEST

        Student test = new Student(1,"Paul","George",1);
        Student test2 = new Student(2,"Peter","Griffin",2);

        marshal(Student.class,test,"testStudent");

        List<Student> studentList = new ArrayList<>();
        studentList.add(test);
        studentList.add(test2);
        Students students = new Students();
        students.setStudents(studentList);
        marshal(Students.class,students,"testStudent2");
        unMarshal();
    }
    public static void marshal(Class c,Object o, String fileName) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(c);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(o, new File("src/main/resources/XML/"+fileName+".xml"));
    }

    private static void unMarshal() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //We had written this file in marshalling example
        Student stu = (Student) jaxbUnmarshaller.unmarshal( new File("src/main/resources/XML/testStudent.xml") );
        System.out.println(stu);

    }
}
