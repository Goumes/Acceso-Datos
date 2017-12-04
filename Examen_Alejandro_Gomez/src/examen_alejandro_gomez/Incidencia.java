/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_alejandro_gomez;

import java.math.BigDecimal;

/**
 *
 * @author agomez
 */
public class Incidencia 
{
    private String matricula;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private String descripcion;
    private String tipo;

    public Incidencia(String matricula, BigDecimal latitud, BigDecimal longitud, String descripcion, String tipo) 
    {
        this.matricula = matricula;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Incidencia() 
    {
        this.matricula = "";
        this.latitud = BigDecimal.ZERO;
        this.longitud = BigDecimal.ZERO;
        this.descripcion = "";
        this.tipo = "";
        
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
