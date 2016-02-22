package pl.jcygan.jdox;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassFieldUtility {
    public static Method[] getGetterAndSetterMethods(Class destinationClass, Field field) throws IntrospectionException {
        PropertyDescriptor propertyDescriptor;
        Method[] result = new Method[2];

        try {
            propertyDescriptor = new PropertyDescriptor(field.getName(), destinationClass);
            try {
                Method setter = propertyDescriptor.getWriteMethod();
                result[1] = setter;
//                System.out.println("Have setter");
            } catch (Exception e) {
//                System.out.println("No setter");
            }

            try {
                Method getter = propertyDescriptor.getReadMethod();
                result[0] = getter;
//                System.out.println("Have getter");
            } catch (Exception e) {
//                System.out.println("No getter");
            }
        } catch (IntrospectionException e) {
//            System.out.println("---");
//            e.printStackTrace();
        }

        return result;
    }
}
