package org.ucu.utils;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * Creado el dia 15/03/15,
 * Integrantes: Fernando Torterolo.
 */
public class TestReadFile extends TestCase {


  public void testReader() {

    boolean res = false;
    try {
      String [] lineas = ReadStringFromFileLineByLine.read("CadenasValidas.txt");

      for (String linea : lineas) {
        System.out.println(linea);
      }

      res=true;
    } catch (IllegalStateException e) {
      e.printStackTrace();
    }
    assertTrue("Problemas al leer el archivo", res);
  }


}
