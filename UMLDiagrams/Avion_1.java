/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_alejandro_gomez;

import java.sql.Date;

/**
 *
 * @author agomez
 */
public class Avion 
{
    private String matricula;
    private String nombre;
    private int idFabricante;
    private String modelo;
    private Date fechaFabricacion;
    private Date fechaEntrada;
    private int fila;
    private int asientoFila;
    private int autonomia;
    
    public Avion ()
    {
        this.matricula = "";
        this.nombre = "";
        this.idFabricante = 0;
        this.modelo = "";
        this.fechaFabricacion = new Date (12,12,12);
        this.fechaEntrada = new Date (12,12,12);
        this.fila = 0;
        this.asientoFila = 0;
        this.autonomia = 0;
    }
    
    public Avion (String matricula, String nombre, int idFabricante, String modelo, Date fechaFabricacion, Date fechaEntrada, int  fila, int asientoFila, int autonomia)
    {
        this.matricula = matricula;
        this.nombre = nombre;
        this.idFabricante = idFabricante;
        this.modelo = modelo;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaEntrada = fechaEntrada;
        this.fila = fila;
        this.asientoFila = asientoFila;
        this.autonomia = autonomia;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdFabricante() {
        return idFabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public int getFila() {
        return fila;
    }

    public int getAsientoFila() {
        return asientoFila;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setAsientoFila(int asientoFila) {
        this.asientoFila = asientoFila;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }
    
    
}
