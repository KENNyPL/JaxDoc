package reflection.data.adapter;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ByteAdapter extends XmlAdapter<String, Byte> {

    @Override
    public Byte unmarshal(String v) throws Exception {
        return DatatypeConverter.parseHexBinary(v)[0];
    }

    @Override
    public String marshal(Byte v) throws Exception {
        return DatatypeConverter.printHexBinary(new byte[] {v});
    }

}
