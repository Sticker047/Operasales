package com.sticker.operasales;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Theatre {

    private final String name;
    private final List<Opera> operaList = new ArrayList<>();

    public Theatre(String name) {
        this.name = name;
    }

    public void addOpera(Opera opera) {
        operaList.add(opera);
    }

    @Override
    public String toString() {
        String res = "В " + name + " идут следующие премьеры:\n\n";

        res += operaList.stream().map(Opera::toString).collect(Collectors.joining("\n\n"));

        return res;
    }

}
