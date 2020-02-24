package hibernate;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor tempInstructor = new Instructor("Arnold","Schwarz","anrold@schwarz.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("youtube.com/luv2code","pls stop");

            session.beginTransaction();

            session.save(tempInstructor);

            System.out.println("Commit transaction");
            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally
        {
            session.close();
            factory.close();
        }
    }
}