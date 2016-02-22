package reflection.data;

import reflection.data.adapter.ByteAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class XmlObject {
    @XmlElement()
    @XmlJavaTypeAdapter(ByteAdapter.class)
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
