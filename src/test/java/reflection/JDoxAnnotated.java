package reflection;

import pl.jcygan.jdox.annotation.JDoxElement;
import pl.jcygan.jdox.annotation.JDoxRootElement;

@JDoxRootElement(indexing = JDoxRootElement.Indexing.AUTO, prefix = "[", suffix = "]")
public class JDoxAnnotated {
    @JDoxElement(suffix = ";")
    private String cashierName;
    @JDoxElement(prefix = "$", suffix = ";")
    public static final String nazwisko = "Cygan";
    private Long shiftNumber;

    public JDoxAnnotated() {
    }

    public JDoxAnnotated(String cashierName, Long shiftNumber) {
        this.cashierName = cashierName;
        this.shiftNumber = shiftNumber;
    }

    public Long getShiftNumber() {
        return shiftNumber;
    }

    public void setShiftNumber(Long shiftNumber) {
        this.shiftNumber = shiftNumber;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }
}
