package ru.University.UDB;

import org.hibernate.Session;
import ru.University.UDB.entity.models.Faculty;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        Faculty faculty = new Faculty();
        faculty.setAbbriviation("tst");
        faculty.setStudyingDuration("tst");

        session.delete(faculty);
        session.getTransaction().commit();

        session.close();
        HibernateUtil.shutdown();
    }
}
