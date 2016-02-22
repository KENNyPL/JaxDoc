package pl.jcygan.jdox.format;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static pl.jcygan.jdox.format.JDoxEnumFieldUtil.getEnumValue;

public class JDoxFieldFormatResolverString extends JDoxFieldFormatResolver<Object> {

    @Override
    public Object unmarshal(String v) throws Exception {
        throw new NotImplementedException();
    }

    @Override
    public String marshal(Object o) throws Exception {
        if (o instanceof Enum) {
            o = getEnumValue(o);
        }
        if (o == null) {
            return "";
        }
        return o.toString();
    }
}
