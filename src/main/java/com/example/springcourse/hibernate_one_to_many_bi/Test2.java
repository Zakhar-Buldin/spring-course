package com.example.springcourse.hibernate_one_to_many_bi;

import com.example.springcourse.hibernate_one_to_many_bi.entity.Department;
import com.example.springcourse.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test2 {
    public static void main(String[] args) {

        /*
        SessionFactory - это фабрика по производству сессий. SessionFactory читает файл hibernate.cfg.xml,
        после чего SessionFactory знает, как должны создаваться сессии.

        В Java приложении достаточно создать объект SessionFactory 1 раз и затем можно его переиспользовать.
         */
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")  // Указывает файл конфигурации Hibernate
                .addAnnotatedClass(Employee.class) // Добавляем класс, имеющий спец. аннотации для работы с БД
                .addAnnotatedClass(Department.class) // Добавляем класс, имеющий спец. аннотации для работы с БД
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession(); // Получение текущей сессии для работы с БД

            session.beginTransaction(); // Открываем транзакцию

            Department department = session.find(Department.class, 1);

            System.out.println(department);
            System.out.println(department.getEmployeeList());

            session.getTransaction().commit(); // Подтверждаем и закрываем транзакию


        }
        finally {
            if (session != null && session.isOpen()) {
                session.close(); // Закрываем сессию
            }
            factory.close(); // Закрытие SessionFactory
        }


    }
}
