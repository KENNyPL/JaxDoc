package reflection.data.novitus;

import pl.jcygan.jdox.annotation.JDoxElement;
import pl.jcygan.jdox.annotation.JDoxIgnore;
import pl.jcygan.jdox.annotation.JDoxRootElement;
import pl.jcygan.jdox.format.JDoxFieldFormatResolverDecValue;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@JDoxRootElement(style = JDoxRootElement.Style.OTHER, prefix = "\u001BP", suffix = "\u001B\\")
public class ReceiptLine {
    @JDoxIgnore
    public static final String CR = "\r\n";

    @XmlJavaTypeAdapter(JDoxFieldFormatResolverDecValue.class)
    private byte number;
    public static final String command = "$l";

    @JDoxElement(suffix = CR)
    private String name;

    @JDoxElement(suffix = CR)
    private long quantity;

    @JDoxElement(suffix = "/")
    private char taxSymbol;

    @JDoxElement(suffix = "/")
    private double price;

    @JDoxElement(suffix = "/")
    private double brutto;

    @JDoxElement
    private String checksum="BB";

    public ReceiptLine() {
    }

    public ReceiptLine(byte number, String name, long quantity, char taxSymbol, double price, double brutto) {
        this.number = number;
        this.name = name;
        this.quantity = quantity;
        this.taxSymbol = taxSymbol;
        this.price = price;
        this.brutto = brutto;
    }

    public byte getNumber() {
        return number;
    }

    public void setNumber(byte number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public char getTaxSymbol() {
        return taxSymbol;
    }

    public void setTaxSymbol(char taxSymbol) {
        this.taxSymbol = taxSymbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
