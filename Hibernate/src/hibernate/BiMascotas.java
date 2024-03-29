package hibernate;
// Generated 23-ene-2018 8:58:01 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BiMascotas generated by hbm2java
 */
public class BiMascotas  implements java.io.Serializable {


     private String codigo;
     private BiClientes biClientes;
     private String raza;
     private String especie;
     private Date fechaNacimiento;
     private Date fechaFallecimiento;
     private String alias;
     private Set biVisitases = new HashSet(0);
     private Set biMascotasEnfermedadeses = new HashSet(0);

    public BiMascotas() {
    }

	
    public BiMascotas(String codigo, BiClientes biClientes, String raza, String especie, Date fechaNacimiento, String alias) {
        this.codigo = codigo;
        this.biClientes = biClientes;
        this.raza = raza;
        this.especie = especie;
        this.fechaNacimiento = fechaNacimiento;
        this.alias = alias;
    }
    public BiMascotas(String codigo, BiClientes biClientes, String raza, String especie, Date fechaNacimiento, Date fechaFallecimiento, String alias, Set biVisitases, Set biMascotasEnfermedadeses) {
       this.codigo = codigo;
       this.biClientes = biClientes;
       this.raza = raza;
       this.especie = especie;
       this.fechaNacimiento = fechaNacimiento;
       this.fechaFallecimiento = fechaFallecimiento;
       this.alias = alias;
       this.biVisitases = biVisitases;
       this.biMascotasEnfermedadeses = biMascotasEnfermedadeses;
    }
   
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public BiClientes getBiClientes() {
        return this.biClientes;
    }
    
    public void setBiClientes(BiClientes biClientes) {
        this.biClientes = biClientes;
    }
    public String getRaza() {
        return this.raza;
    }
    
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public String getEspecie() {
        return this.especie;
    }
    
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Date getFechaFallecimiento() {
        return this.fechaFallecimiento;
    }
    
    public void setFechaFallecimiento(Date fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }
    public String getAlias() {
        return this.alias;
    }
    
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public Set getBiVisitases() {
        return this.biVisitases;
    }
    
    public void setBiVisitases(Set biVisitases) {
        this.biVisitases = biVisitases;
    }
    public Set getBiMascotasEnfermedadeses() {
        return this.biMascotasEnfermedadeses;
    }
    
    public void setBiMascotasEnfermedadeses(Set biMascotasEnfermedadeses) {
        this.biMascotasEnfermedadeses = biMascotasEnfermedadeses;
    }




}


