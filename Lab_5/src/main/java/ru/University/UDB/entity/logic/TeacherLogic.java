package ru.University.UDB.entity.logic;

import org.hibernate.Session;
import ru.University.UDB.entity.models.Teacher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TeacherLogic {
    public List<Teacher> getFullList(Session session) {
        return session.createCriteria(Teacher.class).list();
    }

    public Teacher getElement(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        return session.get(Teacher.class, Integer.parseInt(id));
    }

    public void createOrUpdate(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        if (session.get(Teacher.class, Integer.parseInt(id)) != null) {
            session.update(new Teacher(Integer.parseInt(id), sc.next(), Integer.parseInt(sc.next()),
                    LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH)),
                    Integer.parseInt(sc.next())));
        } else {
            Teacher teacher = new Teacher();
            teacher.setFlm(sc.next());
            teacher.setEducationLicense(Integer.parseInt(sc.next()));
            teacher.setGettigStarted(LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH)));
            session.save(teacher);
        }
    }

    public void delete(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        session.delete(new Teacher(Integer.parseInt(id), "", null, null, null));
    }
}
