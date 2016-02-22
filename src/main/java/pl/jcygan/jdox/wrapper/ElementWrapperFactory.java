package pl.jcygan.jdox.wrapper;

import pl.jcygan.jdox.annotation.JDoxElement;
import pl.jcygan.jdox.annotation.JDoxRootElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.Field;

public class ElementWrapperFactory {

    public static JDoxStyleWrapper getElementWrapper(Object object) throws Exception {
        if(object instanceof Field){
            return getElementWrapper((Field) object);
        }
        if (object.getClass().isAnnotationPresent(JDoxRootElement.class)) {
            return getFieldWrapperByJDoxRootElementAnnotation(object);
        } else if (object.getClass().isAnnotationPresent(XmlRootElement.class)) {
            return new XMLStyleWrapper(object);
        }
        return new BasicStyleWrapper(object);
    }

    public static JDoxStyleWrapper getFieldWrapperByJDoxRootElementAnnotation(Object object) throws Exception {
        JDoxRootElement jDoxRootElementAnnotation = object.getClass().getAnnotation(JDoxRootElement.class);
        if(jDoxRootElementAnnotation!= null){
            if(jDoxRootElementAnnotation.style()== JDoxRootElement.Style.XML){
                return new XMLStyleWrapper(object);
            }
        }
        return new BasicStyleWrapper(object);
    }
}
