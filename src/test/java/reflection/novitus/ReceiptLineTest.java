package reflection.novitus;


import org.junit.Test;
import pl.jcygan.jdox.Marshaller;
import reflection.data.novitus.ReceiptLine;

import static org.junit.Assert.assertEquals;

public class ReceiptLineTest {
    public static final String CR="\r\n";
    @Test
    public void shouldValidMarshal() throws Exception {
        ReceiptLine line = new ReceiptLine((byte)23, "Towar specjalny",2L, 'A', 11.20, 22.40 );
        Marshaller marshaller = new Marshaller(null);


        System.out.println();
        for(byte b: marshaller.marshall(line)){
            System.out.print(b + ",");
        }
        System.out.println();
        System.out.println(new String(marshaller.marshall(line)));

        assertEquals(new String(marshaller.marshall(line)),"\u001BP"+"\u0017"+"$lTowar specjalny"+CR+2+CR+"A"+"/"+11.20+"/"+22.40+"/"+"BB"+"\u001B\\");
    }
}
