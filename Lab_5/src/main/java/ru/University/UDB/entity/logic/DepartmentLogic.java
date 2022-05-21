package ru.University.UDB.entity.logic;

import org.hibernate.Session;
import ru.University.UDB.entity.models.Department;

import java.util.List;
import java.util.Scanner;

public class DepartmentLogic {
    public List<Department> getFullList(Session session) {
        return session.createCriteria(Department.class).list();
    }

    public Department getElement(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        return session.get(Department.class, Integer.parseInt(id));
    }

    public void createOrUpdate(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        if (session.get(Department.class, Integer.parseInt(id)) != null) {
            session.update(new Department(Integer.parseInt(id),
                    sc.next(), Integer.parseInt(sc.next())));
        } else {
            Department department = new Department();
            department.setNaming(sc.next());
            session.save(department);
        }
    }

    public void delete(Session session) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        session.delete(new Department(Integer.parseInt(id), "", null));
    }
}
