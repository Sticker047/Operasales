package com.sticker.operaSales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO: 20. Spring Boot и Java-based конфигурация

/*
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


@SpringBootApplication
public class OperaSalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperaSalesApplication.class, args);

        Theatre theatre = new Theatre("Большой театр");

        int opera1 = theatre.addOpera(new Opera("Назад в будущее", "Шедевр", 12, 30));
        int opera2 = theatre.addOpera(new Opera("Назад в будущее 2", "Шедевр2", 12, 30));
        int opera3 = theatre.addOpera(new Opera("Назад в будущее3", "Шедевр3", 12, 30));



        theatre.getOpera(opera1).setAgeCategory(18);
        theatre.getOpera(opera1).setDefinition("Новое описание");

        theatre.demo();

        theatre.getOpera(opera2).buyTicket(20);
        theatre.getOpera(opera2).buyTicket(21);
        theatre.getOpera(opera2).demo();

        theatre.getOpera(opera3).buyTicket(3);
        theatre.getOpera(opera3).returnTicket(3);

        theatre.demo();
    }

}