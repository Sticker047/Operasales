package com.sticker.operaSales;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class Opera {
    private String name;
    private String definition;
    private int ageCategory;
    private boolean[] places;
    private int width = 10;


    public Opera(String name, String definition, int ageCategory, int placesCount) {
        this.name = name;
        this.definition = definition;
        this.ageCategory = ageCategory;
        places = new boolean[placesCount];
    }

    public void buyTicket(int ticket) {
        places[ticket] = true;
    }

    public void returnTicket(int ticket) {
        places[ticket] = false;
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

        String res = list.stream().collect(Collectors.joining(" "));

        return
                name + "\nВозрастная категория: " + ageCategory +
                        "\nМест в наличии: " + countFreePlaces() +
                        "\nСвободные места: " + res
                ;
    }

    public void demo() {
        System.out.println(
                name + "\nКраткое описание: " + definition +
                        "\nВозрастная категория: " + ageCategory +
                        "\nМест в наличии: " + countFreePlaces()
        );
    }
}