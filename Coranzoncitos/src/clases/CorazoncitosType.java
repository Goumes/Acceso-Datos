package clases;

import corazonesClases.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorazoncitosType", propOrder = {
    "persona"
})
public class CorazoncitosType {

    @XmlElement(name = "Persona")
    protected List<PersonaType> persona;

    public List<PersonaType> getPersona() {
        if (persona == null) {
            persona = new ArrayList<PersonaType>();
        }
        return this.persona;
    }

}
