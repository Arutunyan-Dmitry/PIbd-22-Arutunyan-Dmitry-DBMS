package ru.University.UDB.entity.logic;

import org.hibernate.Session;
import ru.University.UDB.entity.models.Faculty;

import java.util.List;
import java.util.Scanner;

public class FacultyLogic {

    public List<Faculty> getFullList(Session session) {
        return session.createCriteria(Faculty.class).list();
    }

    //get filtered list
    public List<Faculty> getFilteredList(Session session) {
        return session.createQuery("SELECT f from Faculty f where abbriviation = \'"
            + "gf" +
            "\'", Faculty.class).getResultList();
    }

    public Faculty getElement(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        return session.get(Faculty.class, Integer.parseInt(id));
    }

    public void createOrUpdate(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        if (session.get(Faculty.class, Integer.parseInt(id)) != null) {
            session.update(new Faculty(Integer.parseInt(id),
                    sc.next(), sc.next()));
        } else {
            Faculty faculty = new Faculty();
            faculty.setAbbriviation(sc.next());
            faculty.setStudyingDuration(sc.next());
            session.save(faculty);
        }
    }

    public void delete(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        session.delete(new Faculty(Integer.parseInt(id), "", ""));
    }
}
