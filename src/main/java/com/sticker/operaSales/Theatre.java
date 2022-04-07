package com.sticker.operaSales;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Theatre {

    private final String name;
    private final Map<Integer, Opera> operaStorage = new HashMap<>();

    public Theatre(String name) {
        this.name = name;
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

    public void demo() {
        String res = "В " + name + " идут следующие премьеры:\n\n";

        res += operaStorage.values().stream().map(Opera::toString).collect(Collectors.joining("\n\n"));

        System.out.println(res);
    }

}
