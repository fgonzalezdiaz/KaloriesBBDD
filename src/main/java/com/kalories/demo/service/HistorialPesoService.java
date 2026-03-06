package com.kalories.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalories.demo.model.HistorialPeso;
import com.kalories.demo.repository.HistorialPesoRepository;

@Service
public class HistorialPesoService {

    @Autowired
    HistorialPesoRepository hpr;

    public List<HistorialPeso> findAll() {
        return hpr.findAll();
    }

    public List<HistorialPeso> findByWeight(int peso) {
        return hpr.findByWeight(peso);
    }

    public List<HistorialPeso> findByDate(String fecha) {
        return hpr.findByDate(fecha);
    }

    public int save(HistorialPeso historialPeso) {
        return hpr.save(historialPeso);
    }

    public int delete(HistorialPeso historialPeso) {
        return hpr.delete(historialPeso);
    }

    public List<HistorialPeso> findByIdUser(Long id_user) {
        return hpr.findByIdUser(id_user);
    }

    public List<HistorialPeso> findByIdUserAndWeight(Long id_user, int peso) {
        return hpr.findByIdUserAndWeight(id_user, peso);
    }
}
