package com.sticker.operaSales.objects;

import com.sticker.operaSales.annotations.Notifier;
import com.sticker.operaSales.entities.OperaEntity;
import com.sticker.operaSales.entities.TheatreEntity;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component(value = "theatre")
@NoArgsConstructor
public class Theatre {

    private int theatre_id;
    private String name;
    private Map<Integer, Opera> operaStorage = new HashMap<>();

    public Theatre(String name) {
        this.name = name;
    }

    public Theatre(@NotNull TheatreEntity theatre) {
        theatre_id = theatre.getTheatre_id();
        name = theatre.getName();
        for (OperaEntity opera : theatre.getOperas()) {
            operaStorage.put(opera.getOpera_id(), new Opera(opera));
        }
    }

    public TheatreEntity toTheatreEntity() {
        TheatreEntity theatre = new TheatreEntity();

        return theatre;
    }

    public int getTheatre_id() {
        return theatre_id;
    }

    public int addOpera(Opera opera) {
        int id = operaStorage.size();
        operaStorage.put(id, opera);
        System.out.println("Сохранено под номером " + id);
        return id;
    }

    public void removeOpera(Integer id) {
        if (operaStorage.containsKey(id)) {
            operaStorage.remove(id);
            System.out.println("Премьера " + id + " удалена");
        } else {
            System.out.println("Премьера не найдена");
        }
    }

    public Opera getOpera(Integer id) {
        return operaStorage.get(id);
    }

    @Notifier
    public void demo() {
        String res = "В " + name + " идут следующие премьеры:\n\n";

        res += operaStorage.values().stream().map(Opera::toString).collect(Collectors.joining("\n\n"));

        System.out.println(res);
    }

}
