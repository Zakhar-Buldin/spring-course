package com.example.springcourse.aop;
import org.springframework.stereotype.Component;

@Component // id бина = uniLibrary
public class UniLibrary extends AbstractLibrary {

    @Override
    public void getBook(){
        System.out.println("Мы берём книгу из UniLibrary");
    }

    public void returnBook(){
        System.out.println("Мы возвращаем книгу в UniLibrary");
    }

    public void getMagazine(String magazineName, int magazineId){
        System.out.println("Мы берем журнал из UniLibrary: id = " + magazineId + " name = " + magazineName);
    }

    public void getCustomBook(Book book){
        System.out.println("Мы возвращаем книгу в UniLibrary: " + book.getName());
    }
}
