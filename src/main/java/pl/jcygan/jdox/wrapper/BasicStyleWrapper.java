package pl.jcygan.jdox.wrapper;

public class BasicStyleWrapper extends JDoxStyleWrapper {

    public BasicStyleWrapper(Object object) throws Exception {
        super(object);
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public String getSuffix() {
        return suffix;
    }

    @Override
    public String getPrefix(String elementName) {
        return prefix;
    }

    @Override
    public String getSuffix(String elementName) {
        return prefix;
    }
}
