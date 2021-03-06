package com.sticker.operaSales;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// TODO: 20. Spring Boot и Java-based конфигурация

/**
* Пишем AviaSales для опер.
Необходимо реализовать приложение, которое способно:
1) Добавлять новые премьеры (с указанием названия, подробного описания,
* возрастной категории и количество доступных мест)
2) Изменять показатели премьеры
3) Удалять мероприятие
4) Просматривать список всех мероприятий и какого-то конкретного (с подробным описанием)

5) Покупать билет на мероприятие и сдавать его (если вдруг надо)

DoD: Ссылка на git-репозиторий с Spring Boot приложением, содержащее компоненты,
* реализующие описанный функционал. В main() можно получить компоненты
* и вызвать у них пару методов для демонстрации функционала
* */

// TODO: 21. OperaSales AOP

/**Добавляем в наше приложение компонент "Notifier",
который должен имитировать (или нет) отправку письма после некоторых событий (например, после покупки билета).

DoD: В приложении есть хотя бы одна реализация Notifier,
способная отправлять письмо (или эмулировать этот процесс)
по определенным точкам сопряжения (можно определить их самостоятельно)*/

// TODO: 24. OperaSales Data

/**Добавляем в наше приложение полноценный слой репозиториев.
Меняем коллекции на реальное подключение к БД.
Используем только средства Spring (jdbcTemplate или Spring Data)

DoD: Вся информация, которая должна быть сохранена - сохраняется в реляционную БД*/

// TODO: 29. OperaSales

/**
 * Добавляем в наше приложение web-модуль спринга и необходимые методы и контроллеры
 *
 * DoD: Ветка rest с реализацией REST-сервиса с CRUD-методами на каждый ресурс программы.
 * HATEOAS использовать не нужно
 */



@SpringBootApplication
public class OperaSalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperaSalesApplication.class, args);

        new Program().start();
    }


}