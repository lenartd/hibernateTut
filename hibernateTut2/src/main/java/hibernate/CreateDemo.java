package hibernate;

import entity.Instructor;
import entity.InstructorDetail;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor tempInstructor = new Instructor("Ladislav","Schwarz","ladi@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("youtube.com/mychannel","coding");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.save(tempInstructor);
            session.beginTransaction();

            System.out.println("Commit transaction");
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {

        }
    }
}
