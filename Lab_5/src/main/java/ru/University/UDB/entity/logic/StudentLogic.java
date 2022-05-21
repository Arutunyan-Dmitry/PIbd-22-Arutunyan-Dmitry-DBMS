package ru.University.UDB.entity.logic;

import org.hibernate.Session;
import ru.University.UDB.entity.models.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StudentLogic {
    public List<Student> getFullList(Session session) {
        return session.createCriteria(Student.class).list();
    }

    public Student getElement(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        return session.get(Student.class, Integer.parseInt(id));
    }

    public void createOrUpdate(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        if (session.get(Student.class, Integer.parseInt(id)) != null) {
            session.update(new Student(Integer.parseInt(id), Integer.parseInt(sc.next()),
                    LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH)),
                    sc.next(), Boolean.parseBoolean(sc.next()), Integer.parseInt(sc.next())));
        } else {
            Student student = new Student();
            student.setTin(Integer.parseInt(sc.next()));
            student.setDateOfBirth(LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH)));
            student.setFlm(sc.next());
            student.setStepUpAdmission(Boolean.parseBoolean(sc.next()));
            session.save(student);
        }
    }

    public void delete(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        session.delete(new Student(Integer.parseInt(id), null, null, "", null, null));
    }
}
