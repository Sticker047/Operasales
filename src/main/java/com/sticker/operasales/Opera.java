package com.sticker.operasales;

import lombok.Data;

@Data
public class Opera {
    private String name;
    private String definition;
    private int ageCategory;
    private Place[] places;
    private int width = 10;


    public Opera(String name, String definition, int ageCategory, int placesCount) {
        this.name = name;
        this.definition = definition;
        this.ageCategory = ageCategory;
        places = new Place[placesCount];
        for (int i = 0; i < placesCount; i++) {
            places[i] = new Place();
        }
    }

    public int countFreePlaces() {
        int temp = 0;
        for (Place place : places) {
            if (place.isFree()) temp++;
        }

        return temp;
    }

    public String toString() {
        return
                name + "\nКраткое описание: " + definition +
                        "\nВозрастная категория: " + ageCategory +
                        "\nМест в наличии: " + countFreePlaces();
    }
}