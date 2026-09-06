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
                Session - это основной объект Hibernate для работы с БД.
                Session получаем с помощью SessionFactory.

                С помощью Session мы выполняем операции с Java-объектами:
                добавляем, получаем, изменяем и удаляем их в БД.

                Жизненный цикл Session обычно недолгий:
                получили Session → выполнили необходимые операции → закрыли Session.\
             */

            Employee employee = new Employee("Yaroslav", "Barishev", "Devops", 15);
            session.beginTransaction(); // Открываем транзакцию
            session.persist(employee); // Добавляем employee в БД: под капотом INSERT (синхронизация с БД происходит не сразу)
            session.getTransaction().commit(); // Подтверждаем и закрываем транзакию

            session.close(); // Закрываем сессию


        }
        finally {
            factory.close(); // Закрытие SessionFactory
        }


    }
}
