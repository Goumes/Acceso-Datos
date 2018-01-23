package clases;

import corazonesClases.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreferenciasType", propOrder = {
    "gusto"
})
public class PreferenciasType {

    @XmlElement(name = "Gusto")
    protected List<GustoType> gusto;

    public List<GustoType> getGusto() {
        if (gusto == null) {
            gusto = new ArrayList<GustoType>();
        }
        return this.gusto;
    }
    
    public void imprimir ()
    {
        for (int i = 0; i < this.getGusto ().size(); i++)
        {
            System.out.println(getGusto ().get(i).toString ());
        }
    }

}
