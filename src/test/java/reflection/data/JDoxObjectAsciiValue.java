package reflection.data;


import pl.jcygan.jdox.annotation.JDoxElement;
import pl.jcygan.jdox.annotation.JDoxRootElement;
import pl.jcygan.jdox.format.JDoxFieldFormatResolverDecValue;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@JDoxRootElement()
@XmlRootElement()
public class JDoxObjectAsciiValue {

    public enum Enumeration {
        VALUE,
        @XmlEnumValue("2")
        VALUE2;
    }

    @XmlJavaTypeAdapter(JDoxFieldFormatResolverDecValue.class)
    @JDoxElement(prefix = ";", suffix = ";" /*, format = JDoxElement.Format.ASCII_VALUE*/)
    private byte aByte;
    @XmlJavaTypeAdapter(JDoxFieldFormatResolverDecValue.class)
    @JDoxElement(suffix = ";")
    private char aChar;
    @XmlJavaTypeAdapter(JDoxFieldFormatResolverDecValue.class)
    @JDoxElement(suffix = ";")
    private short aShort;
    @XmlJavaTypeAdapter(JDoxFieldFormatResolverDecValue.class)
    @JDoxElement(suffix = ";")
    private int anInt;
    @XmlJavaTypeAdapter(JDoxFieldFormatResolverDecValue.class)
    @JDoxElement(suffix = ";")
    private long aLong;
    @XmlJavaTypeAdapter(JDoxFieldFormatResolverDecValue.class)
    @JDoxElement(suffix = ";")
    private float aFloat;
    @XmlJavaTypeAdapter(JDoxFieldFormatResolverDecValue.class)
    @JDoxElement(suffix = ";")
    private double aDouble;
    @XmlJavaTypeAdapter(JDoxFieldFormatResolverDecValue.class)
    @JDoxElement(suffix = ";")
    private Enumeration enumeration;

    @XmlElement
    @XmlJavaTypeAdapter(JDoxFieldFormatResolverDecValue.class)
//    @JDoxElement(suffix = ";")
    private String string;

    public JDoxObjectAsciiValue() {
    }

    public JDoxObjectAsciiValue(byte aByte, char aChar, short aShort, int anInt, long aLong, float aFloat, double aDouble, Enumeration enumeration, String string) {
        this.aByte = aByte;
        this.aChar = aChar;
        this.aShort = aShort;
        this.anInt = anInt;
        this.aLong = aLong;
        this.aFloat = aFloat;
        this.aDouble = aDouble;
        this.enumeration = enumeration;
        this.string = string;
    }

    public byte getAByte() {
        return aByte;
    }

    public void setAByte(byte aByte) {
        this.aByte = aByte;
    }

    public char getAChar() {
        return aChar;
    }

    public void setAChar(char aChar) {
        this.aChar = aChar;
    }

    public short getAShort() {
        return aShort;
    }

    public void setAShort(short aShort) {
        this.aShort = aShort;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public long getALong() {
        return aLong;
    }

    public void setALong(long aLong) {
        this.aLong = aLong;
    }

    public float getAFloat() {
        return aFloat;
    }

    public void setAFloat(float aFloat) {
        this.aFloat = aFloat;
    }

    public double getADouble() {
        return aDouble;
    }

    public void setADouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public Enumeration getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
