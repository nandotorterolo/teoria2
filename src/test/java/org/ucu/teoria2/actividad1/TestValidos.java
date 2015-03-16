package org.ucu.teoria2.actividad1;

import junit.framework.TestCase;
import org.ucu.utils.ReadStringFromFileLineByLine;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Creado el dia 15/03/15,
 * Integrantes: Fernando Torterolo.
 *  http://www.objectpartners.com/2013/09/18/the-benefits-of-using-assertthat-over-other-assert-methods-in-unit-tests/
 */
public class TestValidos extends TestCase {

  String [] validos;

  protected void setUp(){
    validos = ReadStringFromFileLineByLine.read("CadenasValidas.txt");
  }

  public void testCases() {
    for (String str : validos)
    {
      assertThat("El resultado de parsear la entrada valida: '" + str, ParserNumeros.parsear(str) , is(true));
    }
  }

}
