package pl.jcygan.jdox.wrapper;

public class XMLStyleWrapper extends JDoxStyleWrapper {

    public XMLStyleWrapper(Object object) throws Exception {
        super(object);
    }

    @Override
    public String getPrefix() {
        return "<" + name + ">";
    }

    @Override
    public String getSuffix() {
        return "</" + name + ">";
    }

    @Override
    public String getPrefix(String elementName) {
        return "<" + elementName + ">";
    }

    @Override
    public String getSuffix(String elementName) {
        return "</" + elementName + ">";
    }
}
