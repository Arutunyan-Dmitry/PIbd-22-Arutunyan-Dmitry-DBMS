package ru.University.UDB.entity.logic;

import org.hibernate.Session;
import ru.University.UDB.entity.models.Discipline;

import java.util.List;
import java.util.Scanner;

public class DisciplineLogic {
    public List<Discipline> getFullList(Session session) {
        return session.createCriteria(Discipline.class).list();
    }

    public Discipline getElement(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        return session.get(Discipline.class, Integer.parseInt(id));
    }

    public void createOrUpdate(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        if (session.get(Discipline.class, Integer.parseInt(id)) != null) {
            session.update(new Discipline(Integer.parseInt(id),
                    sc.next()));
        } else {
            Discipline discipline = new Discipline();
            discipline.setNaming(sc.next());
            session.save(discipline);
        }
    }

    public void delete(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        session.delete(new Discipline(Integer.parseInt(id), ""));
    }
}
