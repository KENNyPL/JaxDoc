package reflection.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HouseNumber {
    private long Primary;
    private long secondary;

    public HouseNumber(long primary, long secondary) {
        Primary = primary;
        this.secondary = secondary;
    }

    public HouseNumber() {
    }

    public long getPrimary() {
        return Primary;
    }

    public void setPrimary(long primary) {
        Primary = primary;
    }

    public long getSecondary() {
        return secondary;
    }

    public void setSecondary(long secondary) {
        this.secondary = secondary;
    }
}
