package pl.jcygan.jdox.format;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.naming.OperationNotSupportedException;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import static pl.jcygan.jdox.format.JDoxEnumFieldUtil.getEnumValue;

public class JDoxFieldFormatResolverDecValue extends JDoxFieldFormatResolver<Object>{


    private static byte[] toBytes(Object object) {
        try {
            return toBytes(Long.parseLong(object.toString()));
        } catch (Exception e) {
            return object.toString().getBytes();
        }
    }

    private static byte[] toBytes(long l) {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        while (l != 0) {
            bytes.add((byte) (l % (0xff + 1)));
            l = l >> 8;
        }
        byte[] bytesp = new byte[bytes.size()];
        for (int i = bytes.size() - 1, j = 0; i >= 0; i--, j++) {
            bytesp[j] = bytes.get(i);
        }
        return bytesp;
    }

    @Override
    public Object unmarshal(String v) throws Exception {
        throw new NotImplementedException();
    }

    @Override
    public String marshal(Object o) throws Exception {
        //todo: to complete
        if (o instanceof String) {
//            System.out.println("IS String");
            return ((String)o);
        }

        if (o instanceof Number) {
            return new String(toBytes(((Number) o).longValue()));
        } else if (o.getClass().equals(Character.class)) {
            return new String(o.toString().getBytes());
        } else if (o instanceof Enum) {
            Object enumValue = getEnumValue(o);

            return new String(toBytes(enumValue));
        }
        throw new OperationNotSupportedException(o.toString());
    }
}
