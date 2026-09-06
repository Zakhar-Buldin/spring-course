package com.example.springcourse.hibernate_test;

import com.example.springcourse.hibernate_test.entity.Employee;
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
                .addAnnotatedClass(Employee.class) // Класс, имеющий спец. аннотации для работы с БД
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession(); // Получаем текущую сессию для работы с БД
            /*
                Session - это основной объект Hibernate для работы с БД.
                Session получаем с помощью SessionFactory.

                С помощью Session мы выполняем операции с Java-объектами:
                добавляем, получаем, изменяем и удаляем их в БД.

                Жизненный цикл Session обычно недолгий:
                получили Session → выполнили необходимые операции → закрыли Session.\
             */

            session.beginTransaction(); // Открываем транзакцию
            Employee employee = session.find(Employee.class, 2); // Получаем объект Employee по id = 2
            System.out.println(employee);
            session.getTransaction().commit(); // Подтверждаем и завершаем транзакцию
            session.close(); // Закрываем сессию

            session = factory.getCurrentSession(); // Получаем текущую сессию для работы с БД
            session.beginTransaction(); // Открываем транзакцию
            List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList(); // Получаем список всех работников; под капотом Hibernate выполняет примерно SELECT * FROM employees
            /*
                Для получения объектов из базы используется HQL (Hibernate Query Language).
                Он очень похож на SQL. Однако в HQL мы работаем именно c JAVA ОБЪЕКТАМИ,
                а не напрямую с таблицами и столбцами,
                т.е. в "from Employee" Employee - это название класса, salary - это поле класса Employee и т.д.
             */

            employees.forEach(System.out::println);
            session.getTransaction().commit(); // Подтверждаем и завершаем транзакцию
            session.close(); // Закрываем сессию

            session = factory.getCurrentSession(); // Получаем текущую сессию для работы с БД
            session.beginTransaction(); // Открываем транзакцию
            List<Employee> new_employees = session
                    .createQuery("from Employee where department = 'IT'", Employee.class)
                    .getResultList(); // Под капотом Hibernate выполняет примерно SELECT * FROM employees WHERE department = 'IT'

            new_employees.forEach(System.out::println);
            session.getTransaction().commit(); // Подтверждаем и завершаем транзакцию
            session.close(); // Закрываем сессию

        }
        finally {
            factory.close(); // Закрытие SessionFactory
        }

    }
}
