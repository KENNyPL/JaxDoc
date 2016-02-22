package reflection.data;

import pl.jcygan.jdox.annotation.JDoxRootElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {
    private String street;
    private HouseNumber number;

    public Address() {
    }

    public Address(String street, HouseNumber number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public HouseNumber getNumber() {
        return number;
    }

    public void setNumber(HouseNumber number) {
        this.number = number;
    }
}
