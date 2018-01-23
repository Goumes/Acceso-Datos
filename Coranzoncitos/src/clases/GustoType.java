package clases;

import corazonesClases.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GustoType", propOrder = {
    "descripcion",
    "valor"
})
public class GustoType {

    @XmlElement(name = "Descripcion", required = true)
    protected String descripcion;
    @XmlElement(name = "Valor")
    protected byte valor;

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String value) {
        this.descripcion = value;
    }
    
    public byte getValor() {
        return valor;
    }

    public void setValor(byte value) {
        this.valor = value;
    }
    
    public String toString ()
    {
        return (this.getDescripcion() + ", " +
                this.getValor());
    }

}
