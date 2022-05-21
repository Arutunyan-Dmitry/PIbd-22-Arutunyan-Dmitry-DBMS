package ru.University.UDB.entity.logic;

import org.hibernate.Session;
import ru.University.UDB.entity.models.Stream;

import java.util.List;
import java.util.Scanner;

public class StreamLogic {
    public List<Stream> getFullList(Session session) {
        return session.createCriteria(Stream.class).list();
    }

    public Stream getElement(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        return session.get(Stream.class, Integer.parseInt(id));
    }

    public void createOrUpdate(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        if (session.get(Stream.class, Integer.parseInt(id)) != null) {
            session.update(new Stream(Integer.parseInt(id),
                    sc.next(), sc.next(), sc.next(),
                    sc.next(), Integer.parseInt(sc.next())));
        } else {
            Stream stream = new Stream();
            stream.setEducationLearningForm(sc.next());
            stream.setEducationTimeForm(sc.next());
            stream.setEducationValueForm(sc.next());
            stream.setGettingNumber(sc.next());
            session.save(stream);
        }
    }

    public void delete(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        session.delete(new Stream(Integer.parseInt(id), "", "", "", "", null));
    }
}
