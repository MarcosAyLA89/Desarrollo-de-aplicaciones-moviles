package Datos;

import java.util.Date;

public class Persona {
    private String dui;
    private String nombre;
    String key;
    private String birthdate;

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    private String genero;

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    private Double peso;
    private Double altura;

    public Persona() {
    }

    public Persona(String dui, String nombre,String fecha,String _genero,Double _peso,Double _altura) {
        this.dui = dui;
        this.nombre = nombre;
        this.birthdate=fecha;
        this.genero=_genero;
        this.peso=_peso;
        this.altura=_altura;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }
}