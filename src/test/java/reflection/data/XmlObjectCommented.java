package reflection.data;


import pl.jcygan.jdox.annotation.JDoxIgnore;
import pl.jcygan.jdox.annotation.JDoxRootElement;

import javax.xml.bind.annotation.XmlTransient;

@JDoxRootElement(style = JDoxRootElement.Style.XML, prefix = "<!--", suffix = "-->")
public class XmlObjectCommented {

    private String value1;

    @XmlTransient
    private String value2;

    @JDoxIgnore
    private String value3;

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }
}