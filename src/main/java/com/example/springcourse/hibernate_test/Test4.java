package com.example.springcourse.hibernate_test;

import com.example.springcourse.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args){

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
                получили Session → выполнили необходимые операции → закрыли Session.
             */

            session.beginTransaction(); // Открываем транзакцию
            Employee employee = session.find(Employee.class, 2); // Получаем объект Employee c id = 2
            if (employee != null) {
                session.remove(employee); // Пометили объект Employee на удаление
            }

            session.getTransaction().commit(); // Подтверждаем и завершаем транзакцию
            /*
                Hibernate отслеживает изменения объекта Employee.

                Примерно происходит следующее:

                    SELECT *
                    FROM employees
                    WHERE id = 2;

                После session.remove(employee) Hibernate видит,
                что объект хотят удалить.

                При flush/commit выполняется примерно:

                    DELETE FROM employees
                    WHERE id = 2;
            */
            session.close(); // Закрываем сессию


            session = factory.getCurrentSession(); // Получаем текущую сессию для работы с БД
            session.beginTransaction(); // Открываем транзакцию
            session.createMutationQuery("delete from Employee where surname = 'Barishev'")
                    .executeUpdate();
            /*
                Для получения объектов из базы используется HQL (Hibernate Query Language).
                Он очень похож на SQL. Однако в HQL мы работаем именно c JAVA ОБЪЕКТАМИ,
                а не напрямую с таблицами и столбцами.

               Hibernate преобразует HQL примерно в такой SQL:
                    DELETE FROM employees
                    WHERE surname = 'Barishev'
             */

            session.getTransaction().commit(); // Подтверждаем и завершаем транзакцию
            session.close(); // Закрываем сессию

        }
        finally {
            factory.close(); // Закрытие SessionFactory
        }


    }
}
