package com.example.springcourse.hibernate_test;
import com.example.springcourse.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {

        /*
        SessionFactory - это фабрика по производству сессий. SessionFactory читает файл hibernate.cfg.xml,
        после чего SessionFactory знает, как должны создаваться сессии.

        В Java приложении достаточно создать объект SessionFactory 1 раз и затем можно его переиспользовать.
         */
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")  // Указывает файл конфигурации Hibernate
                .addAnnotatedClass(Employee.class) // Класс, имеющий спец. аннотации для работы с БД
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession(); // Получение текущей сессии для работы с БД
            /*
            Session - это обёртка вокруг подключения к базе с помошью JDBC.
            Session мы получаем с помошью SessionFactory
            Session - это основа для работы с Базой Данных. Именно с помощью Session мы будем добавлять,
            получать и делать другие операции с Java Объектами в Базе Данных.

            Жизненный цикл Session обычно не велик. Мы получаем Session, делаем с помощью неё определённые операции
            и она становится не нужной.

             */

            Employee employee = new Employee("Zakhar", "Buldin", "IT", 10000000);
            session.beginTransaction(); // Открытие транзакции
            session.persist(employee); // Добавление employee в БД
            session.getTransaction().commit(); // Закрытие транзакции
        }
        finally {
            factory.close(); // Закрытие SessionFactory
        }


    }
}
