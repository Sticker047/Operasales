package com.sticker.operaSales;

import com.sticker.operaSales.annotations.Notifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Opera {
    private String name;
    private String definition;
    private int ageCategory;
    private boolean[] places = new boolean[]{};
    private int placesCount;


    public Opera(String name, String definition, int ageCategory, int placesCount) {
        this.name = name;
        this.definition = definition;
        this.ageCategory = ageCategory;
        this.placesCount = placesCount;
        places = new boolean[this.placesCount];
    }

    public void buyTicket(int ticket) {
        if (ticket < places.length) {
            places[ticket] = true;
        }
        else {
            System.out.println("Неверно выбран билет");
        }
    }

    public void returnTicket(int ticket) {
        if (ticket < places.length) {
            places[ticket] = false;
        }
        else {
            System.out.println("Неверно выбран билет");
        }
    }

    public int countFreePlaces() {
        int temp = 0;
        for (boolean place : places) {
            if (!place) temp++;
        }

        return temp;
    }

    public String toString() {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < places.length; i++) {
            if (!places[i]) {
                list.add("" + i);
            }
        }

        String res = String.join(" ", list);

        return
                name + "\nВозрастная категория: " + ageCategory +
                        "\nМест в наличии: " + countFreePlaces() +
                        "\nСвободные места: " + res
                ;
    }

    @Notifier
    public void demo() {
        System.out.println(
                name + "\nКраткое описание: " + definition +
                        "\nВозрастная категория: " + ageCategory +
                        "\nМест в наличии: " + countFreePlaces()
        );
    }
}