package com.example.springcourse.hibernate_many_to_many;

import com.example.springcourse.hibernate_many_to_many.entity.Child;
import com.example.springcourse.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try{
            session = factory.getCurrentSession();

            Section section1 = new Section("Football");
            Child child1 = new Child("Valera", 11);
            Child child2 = new Child("Stas", 12);
            Child child3 = new Child("Igor", 11);

            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();

            session.persist(section1); // Благодаря каскаду дети тоже добавляются

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();

        }
    }
}
