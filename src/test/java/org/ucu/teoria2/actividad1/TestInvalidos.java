package org.ucu.teoria2.actividad1;

import junit.framework.TestCase;

/**
 * Creado el dia 15/03/15,
 * Integrantes: Fernando Torterolo.
 */
public class TestInvalidos extends TestCase {


  String [] invalidos;
  boolean res;

  protected void setUp(){
    invalidos =new String [] {"abcdef","  123abc", "123abc", "<>9io", "+", "1125,54.125", "125..300",
            "+-10", "10.", "67 89", "", "123.13,05", "eˆ2", " 3, ", "252,12,12", "123.13,05.36", "125,5.2",
            "164.445.843.7899", "22222.222"};

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
