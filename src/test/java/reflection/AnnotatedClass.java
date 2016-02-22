package reflection;

import javax.xml.bind.annotation.XmlElement;

public class AnnotatedClass {
    @XmlElement
    public static final String command ="#e";
    @XmlElement
    private String name;
    @XmlElement
    private Long weight;
    @XmlElement
    private String readOnly;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getReadOnly() {
        return readOnly;
    }
}
