package ru.University.UDB;

import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        //Starting checking time of transaction method
        long startTime = System.nanoTime();

        session.getTransaction().begin();
        /**
         * Usage of any logic classes and their methods here
         */
        session.getTransaction().commit();

        //Ending checking time of transaction method
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println(duration + "ms");

        session.close();
        HibernateUtil.shutdown();
    }
}
