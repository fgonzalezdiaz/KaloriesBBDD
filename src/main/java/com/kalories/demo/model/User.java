package com.kalories.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class User {

    private Long id;
    private String email;
    private String contrasena;
    private String genero;
    private LocalDate fechaNacimiento;
    private Integer altura;
    private BigDecimal peso;
    private Integer nivelActividad;
    private Integer objetivo;
    private String imgPath;

    public User() {
    }

    public User(Long id, String email, String contrasena, String genero, LocalDate fechaNacimiento, Integer altura,
            BigDecimal peso, Integer nivelActividad, Integer objetivo, String imgPath) {
        this.id = id;
        this.email = email;
        this.contrasena = contrasena;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.peso = peso;
        this.nivelActividad = nivelActividad;
        this.objetivo = objetivo;
        this.imgPath = imgPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Integer getNivelActividad() {
        return nivelActividad;
    }

    public void setNivelActividad(Integer nivelActividad) {
        this.nivelActividad = nivelActividad;
    }

    public Integer getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Integer objetivo) {
        this.objetivo = objetivo;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
