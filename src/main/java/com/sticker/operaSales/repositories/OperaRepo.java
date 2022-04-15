package com.sticker.operaSales.repositories;

import com.sticker.operaSales.entities.OperaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperaRepo extends CrudRepository<OperaEntity, Integer> {
}
