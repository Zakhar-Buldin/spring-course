package com.example.springcourse.hibernate_many_to_many;

import com.example.springcourse.hibernate_many_to_many.entity.Child;
import com.example.springcourse.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try{
            session = factory.getCurrentSession();


            session.beginTransaction();

//            Section section = session.find(Section.class, 7);
//            session.remove(section); // Из-за каскада удаляются все дети - это НЕПРАВИЛЬНО!
//            // Лучше так:
//            // cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}

            Child child = session.find(Child.class, 1);
            session.remove(child);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();

        }
    }
}
