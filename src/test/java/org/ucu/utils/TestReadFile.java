package org.ucu.utils;

import junit.framework.TestCase;

/**
 * Creado el dia 15/03/15,
 * Integrantes: Fernando Torterolo.
 */
public class TestReadFile extends TestCase {


  public void testReader() {

    boolean res = false;
    try {
        ReadStringFromFileLineByLine.read("CadenasValidas.txt");
      res = true;
    } catch (IllegalStateException e) {
      e.printStackTrace();
    }
    assertTrue("Problemas al leer el archivo", res);
  }


}
