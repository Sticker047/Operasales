package com.sticker.operaSales.services;

import com.sticker.operaSales.annotations.Notifier;
import com.sticker.operaSales.entities.OperaEntity;
import com.sticker.operaSales.entities.TheatreEntity;
import com.sticker.operaSales.objects.Opera;
import com.sticker.operaSales.repositories.OperaRepo;
import com.sticker.operaSales.repositories.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OperaService {

    @Autowired
    private OperaRepo operaRepo;

//    @Autowired
//    private TheatreRepo theatreRepo;

    private static Map<Integer, Opera> storage = new HashMap<>();

    @Notifier
    public int postOpera(int theatreId, String name, String definition, int ageCategory, int placesCount) {

        Opera opera = new Opera(theatreId, name, definition, ageCategory, placesCount);

        storage.put(storage.size(), opera);

        return storage.size();
    }

    public void postOpera(OperaEntity opera, int theatreId) {
        //TheatreEntity theatre = theatreRepo.findById(theatreId).get();
        opera.setTheatre_id(theatreId);
        operaRepo.save(opera);
    }

    public void putOpera(){

    }

    @Notifier
    public void deleteOpera(int id) {
        operaRepo.deleteById(id);
    }

    @Notifier
    public static Opera getOpera(int id) {
        return storage.get(id);
    }
}
