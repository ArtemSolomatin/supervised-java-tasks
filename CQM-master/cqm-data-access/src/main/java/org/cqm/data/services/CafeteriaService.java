package org.cqm.data.services;

import org.cqm.data.entity.Cafeteria;
import org.cqm.data.repositories.CafeteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cafeteriaService")
public class CafeteriaService {

    @Autowired
    CafeteriaRepository cafeteriaRepository;

    public CafeteriaRepository getCafeteriaRepository() {
        return this.cafeteriaRepository;
    }

    public Integer findCafeIdByCafeName(String cafeName) {
        List<Cafeteria> cafeterias = cafeteriaRepository.findByCafeName(cafeName);
        if (cafeterias == null || cafeterias.isEmpty())
            return null;
        return cafeterias.get(0).getCafeId();
    }
}
