package com.sticker.operaSales.services;

import com.sticker.operaSales.entities.TheatreEntity;
import com.sticker.operaSales.exceptions.TheatreAlreadyExistException;
import com.sticker.operaSales.objects.Theatre;
import com.sticker.operaSales.repositories.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class TheatreService {

    @Autowired
    private TheatreRepo theatreRepo;

    private static Map<Integer, Theatre> storage = new HashMap<>();

    public Theatre createTheatre(TheatreEntity theatre) throws TheatreAlreadyExistException {
        if (theatreRepo.findByTheatreName(theatre.getName()) != null) {
            throw new TheatreAlreadyExistException("Такой театр уже есть");
        }
        theatreRepo.save(theatre);
        return new Theatre(theatre);
    }

}
