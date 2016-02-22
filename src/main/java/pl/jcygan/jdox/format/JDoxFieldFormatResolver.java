package pl.jcygan.jdox.format;

import javax.naming.OperationNotSupportedException;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.lang.reflect.Type;

public abstract class JDoxFieldFormatResolver<BoundType> extends XmlAdapter<String, BoundType> {

}
