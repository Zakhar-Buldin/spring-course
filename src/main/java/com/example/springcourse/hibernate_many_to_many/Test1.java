package com.example.springcourse.hibernate_many_to_many;

import com.example.springcourse.hibernate_many_to_many.entity.Child;
import com.example.springcourse.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try{
            session = factory.getCurrentSession();

            Child child1 = new Child("Ivan", 14);
            Section section1 = new Section("Hockey");
            Section section2 = new Section("Volleyball");
            Section section3 = new Section("Music");

            child1.addSectionToChild(section1);
            child1.addSectionToChild(section2);
            child1.addSectionToChild(section3);

            session.beginTransaction();

            session.persist(child1); // Благодаря каскаду секции тоже добавляются

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();

        }
    }
}
