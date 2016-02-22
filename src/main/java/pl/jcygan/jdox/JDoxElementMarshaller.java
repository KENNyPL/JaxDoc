//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package pl.jcygan.jdox;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Iterator;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import pl.jcygan.jdox.ClassFieldUtility;
import pl.jcygan.jdox.annotation.JDoxElement;
import pl.jcygan.jdox.format.JDoxFieldFormatResolverString;
import pl.jcygan.jdox.wrapper.JDoxStyleWrapper;

class JDoxElementMarshaller {
    private final Class annotationClass = JDoxElement.class;
    private Object object;
    private String prefix = "";
    private String suffix = "";
    private JDoxStyleWrapper styleWrapper;
    private String fieldName = "";
    private String fieldWrapperName = null;

    JDoxElementMarshaller(Object object) {
        this.object = object;
    }

    public String marshall(Field field, Class destinationClass) throws Exception {
        JDoxElement annotation = (JDoxElement)field.getAnnotation(this.annotationClass);
        this.resolveFieldName(field);
        if(annotation != null) {
            this.prefix = annotation.prefix();
            this.suffix = annotation.suffix();
        } else {
            this.prefix = "";
            this.suffix = "";
        }

        String fieldValue = this.resolveFieldValue(field, destinationClass);
        return fieldValue;
    }

    private void resolveFieldName(Field field) {
        JDoxElement jDoxElement = (JDoxElement)field.getAnnotation(JDoxElement.class);
        XmlElement xmlElement = (XmlElement)field.getAnnotation(XmlElement.class);
        this.fieldName = field.getName();
        if(jDoxElement != null) {
            if(jDoxElement.name() != null && jDoxElement.name().length() > 0) {
                this.fieldName = jDoxElement.name();
            }
        } else if(xmlElement != null && xmlElement.name() != null && xmlElement.name().length() > 0) {
            this.fieldName = xmlElement.name();
        }

    }

    private String resolveFieldValue(Field field, Class destinationClass) throws Exception {
        XmlAdapter resolver = this.getFieldResolver(field);
        StringBuffer buffer = new StringBuffer();
        if(Collection.class.isAssignableFrom(field.getType())) {
            Collection objectCollection = (Collection)ClassFieldUtility.getGetterAndSetterMethods(destinationClass, field)[0].invoke(this.object, (Object[])null);
            if(this.fieldWrapperName != null) {
                buffer.append(this.styleWrapper.getPrefix(this.fieldWrapperName));
            }

            Iterator i$ = objectCollection.iterator();

            while(i$.hasNext()) {
                Object obj = i$.next();
                buffer.append(this.styleWrapper.getPrefix(this.fieldName));
                buffer.append(resolver.marshal(obj).toString());
                buffer.append(this.styleWrapper.getSuffix(this.fieldName));
            }

            if(this.fieldWrapperName != null) {
                buffer.append(this.styleWrapper.getSuffix(this.fieldWrapperName));
            }
        } else {
            buffer.append(this.styleWrapper.getPrefix(this.fieldName));
            buffer.append(this.prefix);
            if(Modifier.isPublic(field.getModifiers())) {
                buffer.append(resolver.marshal(field.get(this.object)).toString());
            } else {
                buffer.append(resolver.marshal(ClassFieldUtility.getGetterAndSetterMethods(destinationClass, field)[0].invoke(this.object, (Object[])null)).toString());
            }

            buffer.append(this.suffix);
            buffer.append(this.styleWrapper.getSuffix(this.fieldName));
        }

        return buffer.toString();
    }

    public XmlAdapter getFieldResolver(Field field) throws Exception {
        XmlJavaTypeAdapter annotation = (XmlJavaTypeAdapter)field.getAnnotation(XmlJavaTypeAdapter.class);
        return (XmlAdapter)(annotation != null && annotation.value() != null?(XmlAdapter)annotation.value().newInstance():new JDoxFieldFormatResolverString());
    }

    public JDoxElementMarshaller withStyleWrapper(JDoxStyleWrapper styleWrapper) {
        this.styleWrapper = styleWrapper;
        return this;
    }
}
