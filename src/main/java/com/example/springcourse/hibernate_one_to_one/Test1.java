package com.example.springcourse.hibernate_one_to_one;
import com.example.springcourse.hibernate_one_to_one.entity.Employee;
import com.example.springcourse.hibernate_one_to_one.entity.Detail;
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

            Employee employee = new Employee("Nastya", "Sineva", "Musin", 300);
            Detail detail = new Detail("Moscow", "1234567890", "stasiany@gmail.com");

            employee.setEmpDetail(detail); // Двусторонняя связь (необходимо у обоих объектов создать ссылку друг на друга)
            detail.setEmployee(employee);

            session.beginTransaction(); // Открываем транзакцию

            session.persist(detail); // Добавляем объект Detail в таблицу (Employee добавится автоматически благодаря каскаду)

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
