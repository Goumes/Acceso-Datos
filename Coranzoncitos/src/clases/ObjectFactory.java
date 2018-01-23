package clases;

import corazonesClases.*;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Corazoncitos_QNAME = new QName("", "Corazoncitos");

    public ObjectFactory() {
    }

    public CorazoncitosType createCorazoncitosType() {
        return new CorazoncitosType();
    }

    public GustoType createGustoType() {
        return new GustoType();
    }

    public PreferenciasType createPreferenciasType() {
        return new PreferenciasType();
    }

    public PersonaType createPersonaType() {
        return new PersonaType();
    }

    @XmlElementDecl(namespace = "", name = "Corazoncitos")
    public JAXBElement<CorazoncitosType> createCorazoncitos(CorazoncitosType value) {
        return new JAXBElement<CorazoncitosType>(_Corazoncitos_QNAME, CorazoncitosType.class, null, value);
    }

}
