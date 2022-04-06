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

    public void addOpera(Opera opera) {
        Integer id = operaStorage.size();
        operaStorage.put(id, opera);
    }

    public void removeOpera(Integer id) {
        operaStorage.remove(id);
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
