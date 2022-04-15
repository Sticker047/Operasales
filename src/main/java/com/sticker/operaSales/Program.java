package com.sticker.operaSales;

import com.sticker.operaSales.entities.TheatreEntity;
import com.sticker.operaSales.exceptions.TheatreAlreadyExistException;
import com.sticker.operaSales.objects.Theatre;
import com.sticker.operaSales.services.OperaService;
import com.sticker.operaSales.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;

public class Program {

    @Autowired
    private OperaService operaService;

    @Autowired
    private TheatreService theatreService;

    public void start() {
        Theatre theatre = null;
        try {
            theatre = theatreService.createTheatre(new TheatreEntity());
        } catch (TheatreAlreadyExistException e) {
            e.printStackTrace();
        }
        new Theatre("Большой театр");

        int opera1 = operaService.postOpera(
                theatre.getTheatre_id(),
                "Назад в будущее",
                "Шедевр",
                12,
                30);

        int opera2 = operaService.postOpera(
                theatre.getTheatre_id(),
                "Назад в будущее 2",
                "Шедевр 2",
                12,
                30);

        int opera3 = operaService.postOpera(
                theatre.getTheatre_id(),
                "Назад в будущее 3",
                "Шедевр 3",
                12,
                30);

        operaService.getOpera(opera1).setAgeCategory(18);
        operaService.getOpera(opera1).setDefinition("Новое описание");

        theatre.demo();

        operaService.getOpera(opera2).buyTicket(20);
        operaService.getOpera(opera2).buyTicket(21);
        operaService.getOpera(opera2).demo();

        operaService.getOpera(opera3).buyTicket(3);
        operaService.getOpera(opera3).returnTicket(3);

        theatre.demo();

        operaService.deleteOpera(1);

        theatre.demo();
    }
}
