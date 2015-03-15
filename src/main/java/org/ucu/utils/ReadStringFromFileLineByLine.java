package org.ucu.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Creado el dia 15/03/15,
 * Integrantes: Fernando Torterolo.
 */
public  class ReadStringFromFileLineByLine {

  public static String[] read(String fileName) {
    try {

      URL url = Thread.currentThread().getContextClassLoader().getResource(fileName);
      File file = new File(url.getPath());

      FileReader fileReader = new FileReader(file);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      StringBuffer stringBuffer = new StringBuffer();
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        stringBuffer.append(line);
        stringBuffer.append("\n");
      }
      fileReader.close();

      return stringBuffer.toString().split("\n");
      // System.out.println("Contents of file:");
      // System.out.println(stringBuffer.toString());
    }
    catch (IOException e) {
        e.printStackTrace();
        throw new IllegalStateException("error al leer archivo",e);
    }
  }

}
