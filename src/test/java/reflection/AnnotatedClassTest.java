package reflection;

import org.junit.Ignore;
import org.junit.Test;
import pl.jcygan.jdox.ClassFieldUtility;
import pl.jcygan.jdox.Marshaller;
import reflection.data.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlElement;
import java.beans.IntrospectionException;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AnnotatedClassTest {

    @Test
    @Ignore
    public void simpleTest() throws IntrospectionException {
        AnnotatedClass aClass = new AnnotatedClass();

        for (Field field : aClass.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(XmlElement.class)) {
                System.out.println("Annotated: " + field.getName());
                if (!Modifier.isPublic(field.getModifiers())) {
                    System.out.println("Methods: " + ClassFieldUtility.getGetterAndSetterMethods(AnnotatedClass.class, field));
                }
            }
        }
    }

    @Test
    @Ignore
    public void JDoxAnnotationsTest() throws Exception {
        JDoxAnnotated annotated = new JDoxAnnotated("Jakub", 261L);
        Marshaller marshaller = new Marshaller(JDoxAnnotated.class);
        String document =new String(marshaller.marshall(annotated));
        System.out.println(document);
    }

    @Test
    @Ignore
    public void StringTest() throws Exception {
        String t = "ą";
        System.out.println(t.getBytes().length);
    }

    @Test
    public void shouldValidMarshalJDoxObjectToStringFormat() throws Exception {
        JDoxObjectString annotated = new JDoxObjectString((byte) 1, 'ą', (short) 3, 4, 5l, 6.6f, 7.7d, JDoxObjectString.Enumeration.VALUE, "8");
        Marshaller marshaller = new Marshaller(JDoxObjectString.class);
        System.out.println(marshaller.marshall(annotated));
        assertEquals("[STRING]" + ";1;ą;3;4;5;6.6;7.7;VALUE;8;" + "[\\STRING]", new String(marshaller.marshall(annotated)));
    }

    @Test
    public void shouldValidMarshalJDoxObjectToStringFormatWithAnnotatedEnumValue() throws Exception {
        JDoxObjectString annotated = new JDoxObjectString((byte) 1, 'ą', (short) 3, 4, 5l, 6.6f, 7.7d, JDoxObjectString.Enumeration.VALUE2, "8");
        Marshaller marshaller = new Marshaller(JDoxObjectString.class);
        System.out.println(marshaller.marshall(annotated));
        assertEquals("[STRING]" + ";1;ą;3;4;5;6.6;7.7;2;8;" + "[\\STRING]", new String(marshaller.marshall(annotated)));
    }

    @Test
    public void shouldValidMarshalJDoxObjectToAsciiFormat() throws Exception {
        JDoxObjectAsciiValue annotated = new JDoxObjectAsciiValue((byte) 1, 'ą', (short) 3, 4, 5l, 6.6f, 7.7d, JDoxObjectAsciiValue.Enumeration.VALUE, "8");
        Marshaller marshaller = new Marshaller(JDoxObjectAsciiValue.class);
        System.out.println(marshaller.marshall(annotated));
        assertEquals(";" + "\001" + ";" + "ą" + ";" + "\003" + ";" + "\004" + ";" + "\005" + ";" + "\006" + ";" + "\007" + ";" +
                "VALUE;8", new String(marshaller.marshall(annotated)));
    }

    @Test
    public void shouldValidMarshalJDoxObjectToAsciiFormatWithAnnotatedEnumValue() throws Exception {
        JDoxObjectAsciiValue annotated = new JDoxObjectAsciiValue((byte) 1, 'ą', (short) 3, 4, 5l, 6.6f, 7.7d, JDoxObjectAsciiValue.Enumeration.VALUE2, "8");
        Marshaller marshaller = new Marshaller(JDoxObjectAsciiValue.class);
        System.out.println(marshaller.marshall(annotated));
        assertEquals(";" + "\001" + ";" + "ą" + ";" + "\003" + ";" + "\004" + ";" + "\005" + ";" + "\006" + ";" + "\007" + ";" +
                "\002" + ";8", new String(marshaller.marshall(annotated)));
    }

    @Test
    public void shouldIgnoreAnnotatedFieldAsIgnoreAndMarshallAsXml() throws Exception {
        JDoxObjectStringIgnore objectStringIgnore = new JDoxObjectStringIgnore();
        objectStringIgnore.setValue1("1");
        objectStringIgnore.setValue2("2");
        objectStringIgnore.setValue3("3");

        Marshaller marshaller = new Marshaller(JDoxObjectStringIgnore.class);
        System.out.println(marshaller.marshall(objectStringIgnore));
        assertEquals("<JDoxObjectStringIgnore><value1>1</value1></JDoxObjectStringIgnore>", new String(marshaller.marshall(objectStringIgnore)));
    }

    @Test
    public void shouldIgnoreAnnotatedFieldAsIgnoreAndMarshallAsXmlAnnotatedWithStyle() throws Exception {
        XmlObjectAnnotated objectStringIgnore = new XmlObjectAnnotated();
        objectStringIgnore.setValue1("1");
        objectStringIgnore.setValue2("2");
        objectStringIgnore.setValue3("3");

        Marshaller marshaller = new Marshaller(XmlObjectAnnotated.class);
        System.out.println(marshaller.marshall(objectStringIgnore));
        assertEquals("<xmlObjectAnnotated><value1>1</value1></xmlObjectAnnotated>", new String(marshaller.marshall(objectStringIgnore)));
    }

    @Test
    public void shouldValidMarshalCommentedXmlObject() throws Exception {
        XmlObjectCommented objectStringIgnore = new XmlObjectCommented();
        objectStringIgnore.setValue1("1");
        objectStringIgnore.setValue2("2");
        objectStringIgnore.setValue3("3");

        Marshaller marshaller = new Marshaller(XmlObjectCommented.class);
        System.out.println(marshaller.marshall(objectStringIgnore));
        assertEquals("<xmlObjectCommented><!--<value1>1</value1>--></xmlObjectCommented>", new String(marshaller.marshall(objectStringIgnore)));
    }

    @Test
    public void shouldValidMarshallComplexObject() throws Exception {
        Person person = new Person();
        person.setName("Jakub");
        Address address = new Address();
        address.setNumber(new HouseNumber(22, 14));
        address.setStreet("Portowa");
        person.setAddress(address);

        Marshaller marshaller = new Marshaller(Person.class);
        System.out.println(new String(marshaller.marshall(person)));
        assertEquals("<person><name>Jakub</name><surname></surname><height></height><test></test><birthDate></birthDate><address><street>Portowa</street><houseNumber><Primary>22</Primary><secondary>14</secondary></houseNumber></address></person>",
                new String(marshaller.marshall(person)));
    }


    @Test
    public void shouldValidMarshallObjectWithCollection() throws Exception {
        XmlObjectWithCollection objectWithCollection = new XmlObjectWithCollection();
        objectWithCollection.setValue1("Test");
        String[] strings = new String[]{"E1", "E2", "E3"};
        objectWithCollection.setStrings(Arrays.asList(strings));

        JAXBContext context = JAXBContext.newInstance(XmlObjectWithCollection.class);
        javax.xml.bind.Marshaller m = context.createMarshaller();

        Marshaller marshaller = new Marshaller(XmlObjectWithCollection.class);
        System.out.println(new String(marshaller.marshall(objectWithCollection)));
        assertEquals("<xmlObjectWithCollection>" + "<value1>Test</value1>" +
                "<Napisy>E1</Napisy>" +
                "<Napisy>E2</Napisy>" +
                "<Napisy>E3</Napisy>" +
                "</xmlObjectWithCollection>",
                new String(marshaller.marshall(objectWithCollection)));
        System.out.println(new String(marshaller.marshall(objectWithCollection)));


        Writer xmlMarshallerResult = new StringWriter();
        m.marshal(objectWithCollection, xmlMarshallerResult);


        assertEquals(xmlMarshallerResult.toString(),
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + new String(marshaller.marshall(objectWithCollection)));
    }

    @Test
    @Ignore
    public void timersTest() throws Exception {

        Address address = new Address();
        address.setNumber(new HouseNumber(22, 14));
        address.setStreet("Portowa");

        Person person = new Person("asdfghjjkl", "", "", "", new Long(123), address, new Person(), new Person());


        Marshaller marshaller = new Marshaller(Person.class);
        JAXBContext context = JAXBContext.newInstance(Person.class);
        javax.xml.bind.Marshaller m = context.createMarshaller();


        String result1 = null;


        Writer result2 = new StringWriter();
        long begin1 = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            result1 = new String(marshaller.marshall(person));
//            System.out.print((result));
        }
        long end1 = System.currentTimeMillis();

        long begin2 = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            m.marshal(person, result2);
            result1 =result2.toString();
        }
        long end2 = System.currentTimeMillis();


        System.out.println("1: " + (end1 - begin1));
        System.out.println("1: " + (end1 - begin1));

        System.out.println("2: " + (end2 - begin2));
    }
}
