package com.example.springcourse.hibernate_test_2;

import com.example.springcourse.hibernate_test_2.entity.Detail;
import com.example.springcourse.hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
                .addAnnotatedClass(Detail.class) // Добавляем класс, имеющий спец. аннотации для работы с БД
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession(); // Получение текущей сессии для работы с БД
            /*
                Session - это основной объект Hibernate для работы с БД.
                Session получаем с помощью SessionFactory.

                С помощью Session мы выполняем операции с Java-объектами:
                добавляем, получаем, изменяем и удаляем их в БД.

                Жизненный цикл Session обычно недолгий:
                получили Session → выполнили необходимые операции → закрыли Session.
             */

            session.beginTransaction(); // Открываем транзакцию
            Employee employee = session.find(Employee.class, 2); // Находим объект Employee с id = 2
            Detail detail = employee.getEmpDetail(); // Получаем связанный объект Detail

            System.out.println(detail);

//            session.remove(employee); // Благодаря каскаду удалятся и Employee, и связанный Detail

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
