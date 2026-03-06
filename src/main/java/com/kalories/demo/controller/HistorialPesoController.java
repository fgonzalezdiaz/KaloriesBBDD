package com.kalories.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kalories.demo.model.HistorialPeso;
import com.kalories.demo.service.HistorialPesoService;

@RestController
@RequestMapping("/api/historial-peso")
public class HistorialPesoController {

    @Autowired
    HistorialPesoService hps;

    @GetMapping("/findAll")
    public List<HistorialPeso> findAll() {
        return hps.findAll();
    }

    @GetMapping("/findByFecha")
    public List<HistorialPeso> findByDate(@RequestParam String fecha) {
        return hps.findByDate(fecha);
    }

    @GetMapping("/findByPeso")
    public List<HistorialPeso> findByPeso(@RequestParam int peso) {
        return hps.findByWeight(peso);
    }

    @PostMapping("/create")
    public int create(@RequestParam String fecha, @RequestParam int peso, Long id_user) {
        return hps.save(new HistorialPeso(fecha, peso, id_user));
    }

    @DeleteMapping("/delete")
    public int delete(@RequestBody HistorialPeso hp) {
        return hps.delete(hp);
    }

    @GetMapping("/findByIdUser")
    public List<HistorialPeso> getMethodName(@RequestParam Long param) {
        return hps.findByIdUser(param);
    }

    @GetMapping("/findByUserAndWeight")
    public List<HistorialPeso> getMethodName(@RequestParam Long id_user, @RequestParam int peso) {
        return hps.findByIdUserAndWeight(id_user, peso);
    }

}
