package hibernate;

import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] argz) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 3;
            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("instructor: " + tempInstructor);


            if (tempInstructor != null)
            {
                System.out.println("deleting: " + tempInstructor);
                session.delete(tempInstructor);
            }

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
