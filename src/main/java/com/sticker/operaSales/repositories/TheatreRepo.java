package com.sticker.operaSales.repositories;

import com.sticker.operaSales.entities.TheatreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepo extends CrudRepository<TheatreEntity, Integer> {
    TheatreEntity findByTheatreName(String name);
}
