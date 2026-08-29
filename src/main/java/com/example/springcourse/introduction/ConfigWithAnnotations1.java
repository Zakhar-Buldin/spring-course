package com.example.springcourse.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Cat myCat = context.getBean("catBean", Cat.class);
        myCat.say();

        /*
        Конфигурация при помощи аннотаций:
            Процесс состоит из 2-ух этапов:
                1) сканирование классов и поиск аннотации @Component
                2) Создание (регистрация) бина в Spring контейнере

         <context:component-scan base-package="com.example.springcourse.introduction"/> -
         необходимо указать в xml файле.

         "com.example.springcourse.introduction" - пакет, в котором проводится сканирование

        @Component("catBean") // В двойных кавычках указывается id для бина
        public class Cat implements Pet{...}

        Если id не указывать, то Spring создаст его автоматически (@Context).
        Алгоритм создание дефолтного id:
            Class Cat: Cat -> cat
            Class FavoriteSong: FavoriteSong -> favoriteSong
            Class SQLTest: SQLTest -> SQLTest !!!
        */
        context.close();
    }
}
