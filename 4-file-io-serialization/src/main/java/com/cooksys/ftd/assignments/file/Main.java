package com.cooksys.ftd.assignments.file;

import com.cooksys.ftd.assignments.file.model.Contact;
import java.io.File;
import com.cooksys.ftd.assignments.file.model.Instructor;
import com.cooksys.ftd.assignments.file.model.Session;
import com.cooksys.ftd.assignments.file.model.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Creates a {@link Student} object using the given studentContactFile.
     * The studentContactFile should be an XML file containing the marshaled form of a
     * {@link Contact} object.
     *
     * @param studentContactFile the XML file to use
     * @param jaxb the JAXB context to use
     * @return a {@link Student} object built using the {@link Contact} data in the given file
     */
    public static Student readStudent(File studentContactFile, JAXBContext jaxb)throws Exception {
    	
    	Unmarshaller unmarshaller = jaxb.createUnmarshaller();	
    	Contact testStudent = (Contact) unmarshaller.unmarshal(studentContactFile);    	
    	Student st = new Student();
    	st.setContact(testStudent);
    	
    	return st;
    	
    }

    /**
     * Creates a list of {@link Student} objects using the given directory of student contact files.
     *
     * @param studentDirectory the directory of student contact files to use
     * @param jaxb the JAXB context to use
     * @return a list of {@link Student} objects built using the contact files in the given directory
     */
    public static List<Student> readStudents(File studentDirectory, JAXBContext jaxb)throws Exception {
    	
    	JAXBContext jc = JAXBContext.newInstance(Contact.class,Student.class);
    	File [] arrayOfFiles = studentDirectory.listFiles();
    	ArrayList<Student> finalList = new ArrayList<Student>();
    	for(File file : arrayOfFiles)
    	{
    		finalList.add(readStudent(file, jc));	
    	}
    	
        return finalList; // TODO
    }

    /**
     * Creates an {@link Instructor} object using the given instructorContactFile.
     * The instructorContactFile should be an XML file containing the marshaled form of a
     * {@link Contact} object.
     *
     * @param instructorContactFile the XML file to use
     * @param jaxb the JAXB context to use
     * @return an {@link Instructor} object built using the {@link Contact} data in the given file
     */
    public static Instructor readInstructor(File instructorContactFile, JAXBContext jaxb)throws Exception {

    	Unmarshaller unmarshaller = jaxb.createUnmarshaller();    	
    	Contact testStudent = (Contact) unmarshaller.unmarshal(instructorContactFile);
    	Instructor st = new Instructor();
    	st.setContact(testStudent);
    	
    	return st;
    }

    /**
     * Creates a {@link Session} object using the given rootDirectory. A {@link Session}
     * root directory is named after the location of the {@link Session}, and contains a directory named
     * after the start date of the {@link Session}. The start date directory in turn contains a directory named
     * `students`, which contains contact files for the students in the session. The start date directory
     * also contains an instructor contact file named `instructor.xml`.
     *
     * @param rootDirectory the root directory of the session data, named after the session location
     * @param jaxb the JAXB context to use
     * @return a {@link Session} object built from the data in the given directory
     */
    public static Session readSession(File rootDirectory, JAXBContext jaxb) throws Exception {
        
    	Session finalSession = new Session();
    	Unmarshaller unmarshal = jaxb.createUnmarshaller();
    	finalSession = (Session) unmarshal.unmarshal(rootDirectory); 
    	return finalSession; // TODO
    	
    	// If we were required to use this program with multiple 
        
    }

    /**
     * Writes a given session to a given XML file
     *
     * @param session the session to write to the given file
     * @param sessionFile the file to which the session is to be written
     * @param jaxb the JAXB context to use
     */
    public static void writeSession(Session session, File sessionFile, JAXBContext jaxb) {
        Marshaller marshaller;
        try {
            marshaller = jaxb.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);;
            marshaller.marshal(session, sessionFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Main Method Execution Steps:
     * 1. Configure JAXB for the classes in the com.cooksys.serialization.assignment.model package
     * 2. Read a session object from the <project-root>/input/memphis/ directory using the methods defined above
     * 3. Write the session object to the <project-root>/output/session.xml file.
     *
     * JAXB Annotations and Configuration:
     * You will have to add JAXB annotations to the classes in the com.cooksys.serialization.assignment.model package
     *
     * Check the XML files in the <project-root>/input/ directory to determine how to configure the {@link Contact}
     *  JAXB annotations
     *
     * The {@link Session} object should marshal to look like the following:
     *      <session location="..." start-date="...">
     *           <instructor>
     *               <contact>...</contact>
     *           </instructor>
     *           <students>
     *               ...
     *               <student>
     *                   <contact>...</contact>
     *               </student>
     *               ...
     *           </students>
     *      </session>
     */
    public static void main(String[] args) throws Exception {
    	
    	JAXBContext jc = JAXBContext.newInstance(Contact.class,Student.class,Instructor.class,Session.class);
    	Session finalSession = new Session();

    	File studentsPath = new File ("./input/memphis/08-08-2016/students/");
    	File instructorFilePath =  new File ("./input/memphis/08-08-2016/instructor.xml");
    	File writeFilePath = new File ("output/session.xml");

    	finalSession.setInstructor(readInstructor(instructorFilePath, jc));
    	finalSession.setStudents(readStudents(studentsPath, jc));
    	finalSession.setLocation("Memphis");
    	finalSession.setStartDate("1-1-17");
    	readSession(new File("output/session.xml"), jc);
    	writeSession(finalSession, writeFilePath, jc);
    	readSession(new File("output/session.xml"), jc);
    	
        // TODO
    }
}
