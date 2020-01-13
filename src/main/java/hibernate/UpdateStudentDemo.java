package hibernate;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try
        {
            int studentId = 1;
            session = factory.getCurrentSession();
            session.beginTransaction();

            Student student = session.get(Student.class,studentId);

            student.setFirstName("Šašo");

            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();


            session.createQuery("update Student set first_name='Šašo'").executeUpdate();


            session.getTransaction().commit();
        } finally { factory.close(); }
    }
}