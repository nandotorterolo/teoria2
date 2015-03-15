package org.ucu.teoria2.actividad1;

import junit.framework.TestCase;

/**
 * Creado el dia 15/03/15,
 * Integrantes: Fernando Torterolo.
 */
public class TestValidos extends TestCase {


  String [] validos;
  boolean res;

  protected void setUp(){
    validos = new String [] { "123.456","1", "3,14", "1.000", "-5", " - 4,6 ", " 5.000,8", " 500 ", "+2 "} ;
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
