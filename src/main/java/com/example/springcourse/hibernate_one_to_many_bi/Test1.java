package com.example.springcourse.hibernate_one_to_many_bi;

import com.example.springcourse.hibernate_one_to_many_bi.entity.Department;
import com.example.springcourse.hibernate_one_to_many_bi.entity.Employee;
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
                .addAnnotatedClass(Employee.class) // Добавляем класс, имеющий спец. аннотации для работы с БД
                .addAnnotatedClass(Department.class) // Добавляем класс, имеющий спец. аннотации для работы с БД
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession(); // Получение текущей сессии для работы с БД

            Department department = new Department("IT", 300, 1200);
            Employee emp1 = new Employee("Zakhar", "Buldin", 800);
            Employee emp2 = new Employee("Valera", "Ivanov", 1000);

            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);


            session.beginTransaction(); // Открываем транзакцию

            session.persist(department); // Добавляем департамент в таблицу (работники добавятся автоматически благодаря каскаду)


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
