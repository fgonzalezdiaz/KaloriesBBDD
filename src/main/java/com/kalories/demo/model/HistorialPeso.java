package com.kalories.demo.model;

public class HistorialPeso {
    private Long id;
    private String fecha;
    private Integer peso;

    public HistorialPeso() {
    }

    public HistorialPeso(Long id, String fecha, Integer peso) {
        this.id = id;
        this.fecha = fecha;
        this.peso = peso;
    }

    public HistorialPeso(String fecha, Integer peso) {
        this.fecha = fecha;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
}
