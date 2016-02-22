package reflection.data;

import pl.jcygan.jdox.annotation.JDoxElement;
import pl.jcygan.jdox.annotation.JDoxRootElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@JDoxRootElement(style = JDoxRootElement.Style.XML)
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlObjectWithCollection {
    private String value1;

    @XmlElement(name = "Napisy")
    private List<String> strings;

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}
