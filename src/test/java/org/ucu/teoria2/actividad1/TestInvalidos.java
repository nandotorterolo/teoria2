package org.ucu.teoria2.actividad1;

import junit.framework.TestCase;
import org.ucu.utils.ReadStringFromFileLineByLine;

/**
 * Creado el dia 15/03/15,
 * Integrantes: Fernando Torterolo.
 */
public class TestInvalidos extends TestCase {


  String [] invalidos;
  boolean res;

  protected void setUp(){
    invalidos = ReadStringFromFileLineByLine.read("CadenasInvalidas.txt");
  }

  public void testCases() {
    for (String str : invalidos)
    {
      res = ParserNumeros.parsear(str);
      System.out.println( "El resultado de parsear la entrada valida: '" + str + "' es => " + res);
      assertFalse(res);
    }
  }

}
