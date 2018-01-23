package clases;

import corazonesClases.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonaType", propOrder = {
    "id",
    "nombre",
    "sexo",
    "sexoBuscado",
    "fechaNacimiento",
    "ingresos",
    "preferencias"
})
public class PersonaType {

    @XmlElement(name = "ID")
    protected short id;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String sexo;
    @XmlElement(required = true)
    protected String sexoBuscado;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaNacimiento;
    protected float ingresos;
    @XmlElement(name = "Preferencias", required = true)
    protected PreferenciasType preferencias;

    public short getID() {
        return id;
    }

    public void setID(short value) {
        this.id = value;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String value) {
        this.nombre = value;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String value) {
        this.sexo = value;
    }

    public String getSexoBuscado() {
        return sexoBuscado;
    }

    public void setSexoBuscado(String value) {
        this.sexoBuscado = value;
    }

    public XMLGregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(XMLGregorianCalendar value) {
        this.fechaNacimiento = value;
    }

    public float getIngresos() {
        return ingresos;
    }

    public void setIngresos(float value) {
        this.ingresos = value;
    }

    public PreferenciasType getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(PreferenciasType value) {
        this.preferencias = value;
    }
    
    @Override
    public String toString ()
    {
        return (this.getID() + ", " +
                this.getNombre() + ", " +
                this.getSexo() + ", " +
                this.getSexoBuscado() + ", " +
                this.getFechaNacimiento().toString () + ", " +
                this.getIngresos());
    }

}
