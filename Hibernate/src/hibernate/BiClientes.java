package hibernate;
// Generated 23-ene-2018 8:58:01 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * BiClientes generated by hbm2java
 */
public class BiClientes  implements java.io.Serializable {


     private int codigo;
     private String telefono;
     private String direccion;
     private String numeroCuenta;
     private String nombre;
     private Set biMascotases = new HashSet(0);

    public BiClientes() {
    }

	
    public BiClientes(int codigo, String telefono, String direccion) {
        this.codigo = codigo;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public BiClientes(int codigo, String telefono, String direccion, String numeroCuenta, String nombre, Set biMascotases) {
       this.codigo = codigo;
       this.telefono = telefono;
       this.direccion = direccion;
       this.numeroCuenta = numeroCuenta;
       this.nombre = nombre;
       this.biMascotases = biMascotases;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }
    
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getBiMascotases() {
        return this.biMascotases;
    }
    
    public void setBiMascotases(Set biMascotases) {
        this.biMascotases = biMascotases;
    }




}

