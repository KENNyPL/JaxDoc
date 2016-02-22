package pl.jcygan.jdox.format;

import javax.xml.bind.annotation.XmlEnumValue;

class JDoxEnumFieldUtil {
    static Object getEnumValue(Object o) {
        XmlEnumValue annotation = null;
        try {
            annotation = o.getClass().getField(o.toString()).getAnnotation(XmlEnumValue.class);
            if (annotation != null && annotation.value() != null) {
                return annotation.value();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return o;
    }
}
