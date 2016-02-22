package reflection.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    private String name;
    private String surname;
    private String height;
    private String test;
    private Long birthDate;
    private Address address;
    private Person mom;
    private Person father;

    public Person() {
    }

    public Person(String name, String surname, String height, String test, Long birthDate, Address address, Person mom, Person father) {
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.test = test;
        this.birthDate = birthDate;
        this.address = address;
        this.mom = mom;
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person getMom() {
        return mom;
    }

    public void setMom(Person mom) {
        this.mom = mom;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }
}
