package com.example.springcourse.hibernate_many_to_many;

import com.example.springcourse.hibernate_many_to_many.entity.Child;
import com.example.springcourse.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.aop.scope.ScopedProxyUtils;

public class Test3 {
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

            Section section = session.find(Section.class, 1);
            Child child = session.find(Child.class, 4);

            System.out.println(section);
            System.out.println(section.getChildren());

            System.out.println("-------------------------------------------------------------------------------------------------------------");

            System.out.println(child);
            System.out.println(child.getSections());

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();

        }
    }
}
