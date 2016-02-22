package pl.jcygan.jdox.wrapper;

import java.beans.Introspector;
import java.lang.reflect.Field;

public abstract class JDoxStyleWrapper<T> {
    protected Object object;
    protected String prefix = "";
    protected String suffix = "";
    protected String name = "";

    protected JDoxStyleWrapper(Object object) throws Exception {
        this.object = object;
        resolveName();
    }

    protected void resolveName() {
        if (object instanceof Field) {
            Field field = (Field) object;
            name = field.getName();
        } else {
            name = Introspector.decapitalize(object.getClass().getSimpleName());
        }
    }


    public abstract String getPrefix();

    public abstract String getSuffix();

    public abstract String getPrefix(String elementName);

    public abstract String getSuffix(String elementName);
}
