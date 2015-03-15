package org.ucu.teoria2.actividad1;

import junit.framework.TestCase;
import org.ucu.utils.ReadStringFromFileLineByLine;

/**
 * Creado el dia 15/03/15,
 * Integrantes: Fernando Torterolo.
 */
public class TestValidos extends TestCase {


  String [] validos;
  boolean res;

  protected void setUp(){
    validos = ReadStringFromFileLineByLine.read("CadenasValidas.txt");
  }

  public void testCases() {
    for (String str : validos)
    {
      res = ParserNumeros.parsear(str);
      System.out.println( "El resultado de parsear la entrada valida: '" + str + "' es => " + res);
      assertTrue(res);
    }
  }

}
