package pl.jcygan.jdox;

import pl.jcygan.jdox.annotation.JDoxIgnore;
import pl.jcygan.jdox.annotation.JDoxRootElement;
import pl.jcygan.jdox.wrapper.ElementWrapperFactory;
import pl.jcygan.jdox.wrapper.JDoxStyleWrapper;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.lang.reflect.Field;

public class Marshaller {
    private Object object;
    private StringBuilder result;
    private JDoxElementMarshaller elementMarshaller;
    private JDoxStyleWrapper styleWrapper;
    private String elementPrefix = "";
    private String elementSuffix = "";

    public Marshaller(Class aClass) {
    }

    public byte[] marshall(Object object) throws Exception {
        if (object == null) {
            return new byte[0];
        }
        this.object = object;
        init();

        return resolve();
    }

    private void init() throws Exception {
        this.result = new StringBuilder();
        this.elementMarshaller = new JDoxElementMarshaller(object);
        if (!isRootElement(this.object.getClass())) {
            throw new NullPointerException();
        }

        resolveElementWrapper();
        resolveElementPrefixAndSuffix();
    }

    private byte[] resolve() throws Exception {
//        result.append(getElementPrefix());
        appendPrefix();
        marshallFields();
//        result.append(getElementSuffix());
        appendSuffix();

        return result.toString().getBytes();
    }

    private void appendPrefix() {
        result.append(styleWrapper.getPrefix()).append(elementPrefix);
    }

    private void appendSuffix() {
        result.append(elementSuffix).append(styleWrapper.getSuffix());
    }

    private void resolveElementPrefixAndSuffix() {
        try {
            JDoxRootElement rootElementAnnotation = object.getClass().getAnnotation(JDoxRootElement.class);
            elementPrefix = rootElementAnnotation.prefix();
            elementSuffix = rootElementAnnotation.suffix();
        } catch (Exception e) {
//            System.out.println(" WARNING: RootElement not annotated as JDoxRootElement " + object.getClass().getName());
        }
    }

    private void resolveElementWrapper() throws Exception {
        styleWrapper = ElementWrapperFactory.getElementWrapper(object);
    }

    private void marshallFields() throws Exception {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(XmlTransient.class) || field.isAnnotationPresent(JDoxIgnore.class)) {
//                System.out.println("Ignore field: " + field.getName());
            } else {
//                System.out.println("Marshall: " + field.getName());
                if (isRootElement(field.getType())) {
                    Marshaller fieldMarshaller = new Marshaller(field.getType());
                    Object nextObject = ClassFieldUtility.getGetterAndSetterMethods(this.object.getClass(), field)[0].invoke(object, null);
                    result.append(new String(fieldMarshaller.marshall(nextObject)));
                } else {
//                    result.append(styleWrapper.getPrefix(field.getName()));
                    result.append(elementMarshaller.withStyleWrapper(styleWrapper).marshall(field, this.object.getClass()));
//                    result.append(styleWrapper.getSuffix(field.getName()));
                }
            }
        }
    }

    private boolean isRootElement(Class objectClass) {
        return objectClass.isAnnotationPresent(JDoxRootElement.class) || objectClass.isAnnotationPresent(XmlRootElement.class);
    }

    public String getElementPrefix() {
        return styleWrapper.getPrefix() + elementPrefix;
    }

    public String getElementSuffix() {
        return elementSuffix + styleWrapper.getSuffix();
    }
}
