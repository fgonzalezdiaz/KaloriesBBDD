package com.kalories.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<HistorialPeso>> findAll() {
        List<HistorialPeso> list = hps.findAll();
        if (list == null || list.isEmpty()) {
            return null;
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/findByFecha")
    public ResponseEntity<List<HistorialPeso>> findByDate(@RequestParam String fecha) {
        List<HistorialPeso> list = hps.findByDate(fecha);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/findByPeso")
    public ResponseEntity<List<HistorialPeso>> findByPeso(@RequestParam int peso) {
        List<HistorialPeso> list = hps.findByWeight(peso);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
    public ResponseEntity<List<HistorialPeso>> create(@RequestParam String fecha, @RequestParam int peso, @RequestParam Long id_user) {
        hps.save(new HistorialPeso(fecha, peso, id_user));
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<HistorialPeso>> delete(@RequestBody HistorialPeso hp) {
        hps.delete(hp);
        return null;
    }

    @GetMapping("/findByIdUser")
    public ResponseEntity<List<HistorialPeso>> findByIdUser(@RequestParam Long param) {
        List<HistorialPeso> list = hps.findByIdUser(param);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/findByUserAndWeight")
    public ResponseEntity<List<HistorialPeso>> findByUserAndWeight(@RequestParam Long id_user, @RequestParam int peso) {
        List<HistorialPeso> list = hps.findByIdUserAndWeight(id_user, peso);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return ResponseEntity.ok(list);
    }

}
