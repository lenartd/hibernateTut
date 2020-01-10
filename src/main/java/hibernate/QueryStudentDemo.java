package hibernate;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating student object");

            System.out.println("Begin transaction");
            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").list();

            System.out.println("\n\nStudent john doe");
            DisplaySudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();

            DisplaySudents(theStudents);

            System.out.println("Commit transaction");
            session.getTransaction().commit();

            System.out.println("Done");
        } finally {}
    }

    private static void DisplaySudents(List<Student> theStudents) {
        for(Student tempStudent : theStudents)
        {
            System.out.println(tempStudent);
        }
    }
}