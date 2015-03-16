package org.ucu.teoria2.actividad1;

import junit.framework.TestCase;
import org.ucu.utils.ReadStringFromFileLineByLine;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Creado el dia 15/03/15,
 * Integrantes: Fernando Torterolo.
 */
public class TestInvalidos extends TestCase {

  String [] invalidos;

  protected void setUp(){
    invalidos = ReadStringFromFileLineByLine.read("CadenasInvalidas.txt");
  }

  public void testCases() {
    for (String str : invalidos)
    {
        assertThat("El resultado de parsear la entrada valida: '" + str, ParserNumeros.parsear(str), is(false));
    }
  }

}
