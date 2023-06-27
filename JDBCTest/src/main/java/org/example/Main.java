package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.example.Controller.StudentController;
import org.example.Factories.StudentFactory;
import org.example.View.StudentView;
import org.example.dao.MyBatis.ProfessorsDAOMyBatis;
import org.example.dao.MyBatis.StudentDAOMyBatis;
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

    private static final String FILENAME = "src/main/resources/XML/School.xml";

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

        //JAXB MARSHAL AND UNMARSHAL TEST

        Student test = new Student(1,"Paul","George",1);
        Student test2 = new Student(5,"Peter","Griffin",1);

        marshal(Student.class,test,"testStudent");

        List<Student> studentList = new ArrayList<>();
        studentList.add(test);
        studentList.add(test2);
        Students students = new Students();
        students.setStudents(studentList);
        marshal(Students.class,students,"testStudent2");
        unMarshal();

        //JSON SERIALIZE AND UNSERIALIZE TEST
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(test2);
        objectMapper.writeValue(new File("src/main/resources/JSON/test.JSON"),test2);
        Student test3 = objectMapper.readValue(json, Student.class);
        System.out.println(test3.toString());

        //MYBATIS
        System.out.println(StudentDAOMyBatis.getStudentById(4));
        System.out.println(ProfessorsDAOMyBatis.getProfessorById(1));
        //StudentDAOMyBatis.saveStudent(test2);
        //StudentDAOMyBatis.updateStudent(test);
        //StudentDAOMyBatis.removeStudent(test2);

        //FACTORY TEST
        System.out.println("\nFACTORY TEST");
        Student factoryTest = new StudentFactory().getStudent("Student");
        factoryTest.setFirstName("Randy");
        System.out.println(factoryTest.getFirstName());

        //BUILDER TEST
        System.out.println("\nBUILDER TEST");
        Student builderTest = new Student.StudentBuilder(10,"Richard", "Black").withUniversityId(1).build();
        System.out.println(builderTest);

        //PROXY TEST
        System.out.println("\nPROXY TEST");
        IStudent proxyStudent = new StudentProxy(12, "Ted", "Smith", 1);
        proxyStudent.printFullName();

        //FACADE TEST
        System.out.println("\nFACADE TEST");
        CourseStudentFacade facade = new CourseStudentFacade();
        facade.enrollStudent();

        //DECORATOR TEST
        System.out.println("\nDECORATOR TEST");
        APStudent apStudent = new APStudent(15,"Rob", "Stone", 1, 4.5);
        apStudent.printGPA();

        //MVC TEST
        System.out.println("\nMVC TEST");
        Student MVCStudent = StudentDAOMyBatis.getStudentById(2);
        StudentView studentView = new StudentView();

        StudentController studentController = new StudentController(MVCStudent, studentView);
        studentController.updateView();
        studentController.setStudentName("Ben", "Carson");
        studentController.updateView();

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
