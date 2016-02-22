package reflection;


import org.junit.Ignore;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;

@Ignore
public class LearnTest {


    @Test
    public void propertyTest() throws IntrospectionException {
        TestSimpleClass testClass = new TestSimpleClass();
        BeanInfo beanInfo = Introspector.getBeanInfo(testClass.getClass());

        for (PropertyDescriptor property : beanInfo.getPropertyDescriptors()) {
            //all attributes of class.
            System.out.println(property.getName()+" [" +property.getPropertyType() +"] ");
            property.getReadMethod(); // getter
            property.getWriteMethod(); // setter
            System.out.println(property.getReadMethod() + " -- " + property.getWriteMethod());
        }
    }

    @Test
    public void getFields() throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        TestClass testClass = new TestClass();

        int declaredFieldsCount = 0;
        for (Field field : testClass.getClass().getDeclaredFields()) {
            declaredFieldsCount++;
            try {
                if (Modifier.isPublic(field.getModifiers())) {
                    System.out.println("Field " + field.getName() + "[" + field.getType() + "] = " + field.get(testClass));


                } else {
                    System.out.println("Field " + field + "[" + field.getType()+ "] - PRIVATE");


                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), testClass.getClass());
                    try {
                        Method setter = propertyDescriptor.getWriteMethod();
                        System.out.println("Have setter");
                    } catch (Exception e) {
                        System.out.println("No setter");
                    }

                    try {
                        Method getter = propertyDescriptor.getReadMethod();
                        Object value = getter.invoke(testClass, null);
                        System.out.println("value: " + value);
                    } catch (Exception e) {
                        System.out.println("No getter");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void typeTest(){
        Long aLong = new Long(261);
        long code = "ą".charAt(0);
        System.out.println(code);
        byte[] bytes = new byte[]{100,100};
        System.out.println(new String(bytes));
//        System.out.println(Character.toChars(code));


    }
}
