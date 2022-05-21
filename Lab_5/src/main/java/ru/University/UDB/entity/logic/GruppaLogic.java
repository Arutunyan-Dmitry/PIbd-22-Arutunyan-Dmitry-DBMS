package ru.University.UDB.entity.logic;

import org.hibernate.Session;
import ru.University.UDB.entity.models.Gruppa;

import java.util.List;
import java.util.Scanner;

public class GruppaLogic {
    public List<Gruppa> getFullList(Session session) {
        return session.createCriteria(Gruppa.class).list();
    }

    public Gruppa getElement(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        return session.get(Gruppa.class, Integer.parseInt(id));
    }

    public void createOrUpdate(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        if (session.get(Gruppa.class, Integer.parseInt(id)) != null) {
            session.update(new Gruppa(Integer.parseInt(id),
                    sc.next(), Integer.parseInt(sc.next())));
        } else {
            Gruppa gruppa = new Gruppa();
            gruppa.setNaming(sc.next());
            session.save(gruppa);
        }
    }

    public void delete(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        session.delete(new Gruppa(Integer.parseInt(id), "", null));
    }
}
