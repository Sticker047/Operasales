package com.sticker.operaSales.objects;

import com.sticker.operaSales.annotations.Notifier;
import com.sticker.operaSales.entities.OperaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Opera {
    private int id;
    private Theatre theatre;
    private String name;
    private String definition;
    private int ageCategory;
    private boolean[] places = new boolean[]{};
    private int placesCount;

    public Opera(OperaEntity opera) {
        this.id = opera.getOpera_id();
        //this.theatre = opera.getTheatre();
        name = opera.getName();
        definition = opera.getDefinition();
        ageCategory = opera.getAgeCategory();
        placesCount = opera.getPlacesCount();
        places = new boolean[opera.getPlacesCount()];

        String temp = opera.getPlaces();

        for (int i = 0; i < places.length; i++) {
           places[i] = temp.charAt(i) == '0' ? true : false;
        }

    }

    public OperaEntity toOperaEntity(Opera opera){
        OperaEntity operaEntity = new OperaEntity();

        operaEntity.setOpera_id(id);
        operaEntity.setTheatre(theatre.toTheatreEntity());
        operaEntity.setName(name);
        operaEntity.setDefinition(definition);
        operaEntity.setAgeCategory(ageCategory);
        operaEntity.setPlacesCount(placesCount);

        String temp = "";
        for (int i = 0; i < placesCount; i++)
        {
            temp += places[i] ? "1" : "0";
        }
        operaEntity.setPlaces(temp);

        return operaEntity;
    }

    public Opera(int theatreId, String name, String definition, int ageCategory, int placesCount) {
        this.name = name;
        this.definition = definition;
        this.ageCategory = ageCategory;
        this.placesCount = placesCount;
        places = new boolean[this.placesCount];
    }

    public void buyTicket(int ticket) {
        if (ticket < places.length) {
            places[ticket] = true;
        } else {
            System.out.println("Неверно выбран билет");
        }
    }

    public void returnTicket(int ticket) {
        if (ticket < places.length) {
            places[ticket] = false;
        } else {
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